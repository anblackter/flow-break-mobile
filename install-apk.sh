#!/bin/bash

# FlowBreak Mobile - Script de Construcción e Instalación APK
# Este script construye automáticamente el APK y lo instala en dispositivos Android
# 
# Uso:
#   ./install-apk.sh          # Construir solo si es necesario e instalar
#   ./install-apk.sh --force  # Forzar reconstrucción completa e instalar

echo "🚀 FlowBreak Mobile - Constructor e Instalador APK"
echo "=================================================="

# Verificar argumentos
FORCE_BUILD=false
if [[ "$1" == "--force" ]]; then
    FORCE_BUILD=true
    echo "🔄 Modo: Reconstrucción forzada"
else
    echo "🔄 Modo: Construcción inteligente"
fi

# Verificar si ADB está disponible
if ! command -v adb &> /dev/null; then
    echo "❌ Error: ADB no está instalado o no está en el PATH"
    echo "   Instala Android SDK Platform Tools o Android Studio"
    exit 1
fi

# Verificar si hay dispositivos conectados
DEVICES=$(adb devices | grep -v "List of devices" | grep -v "^$" | wc -l)

if [ $DEVICES -eq 0 ]; then
    echo "❌ Error: No hay dispositivos Android conectados"
    echo "   Conecta tu dispositivo via USB y habilita la depuración USB"
    echo "   O inicia un emulador Android"
    exit 1
fi

echo "📱 Dispositivos conectados:"
adb devices

APK_PATH="app/build/outputs/apk/release/app-release.apk"
APK_TYPE="Release"

echo ""
echo "🔨 Verificando y construyendo APK..."

# Verificar si el APK existe y si está actualizado
BUILD_NEEDED=false

if [ "$FORCE_BUILD" = true ]; then
    echo "🔄 Forzando reconstrucción completa..."
    BUILD_NEEDED=true
elif [ ! -f "$APK_PATH" ]; then
    echo "📦 APK no encontrado, construyendo..."
    BUILD_NEEDED=true
else
    echo "📦 APK encontrado, verificando si está actualizado..."
    # Verificar si hay cambios en el código fuente más recientes que el APK
    if find app/src -name "*.kt" -newer "$APK_PATH" | grep -q . 2>/dev/null; then
        echo "📦 Código fuente actualizado, reconstruyendo APK..."
        BUILD_NEEDED=true
    elif find app/build.gradle.kts -newer "$APK_PATH" | grep -q . 2>/dev/null; then
        echo "📦 Configuración de build actualizada, reconstruyendo APK..."
        BUILD_NEEDED=true
    else
        echo "✅ APK está actualizado"
    fi
fi

# Construir APK si es necesario
if [ "$BUILD_NEEDED" = true ]; then
    echo ""
    echo "🏗️  Construyendo APK de producción..."
    echo "   Esto puede tomar unos minutos..."
    
    # Limpiar y construir
    if ./gradlew clean assembleRelease; then
        echo "✅ APK construido exitosamente"
    else
        echo "❌ Error al construir el APK"
        echo "   Verifica que:"
        echo "   - Tengas JDK 11+ instalado"
        echo "   - Android SDK esté configurado correctamente"
        echo "   - No haya errores de compilación"
        exit 1
    fi
fi

# Verificar que el APK existe después de la construcción
if [ ! -f "$APK_PATH" ]; then
    echo "❌ Error: APK no se pudo generar en $APK_PATH"
    exit 1
fi

echo ""
echo "📦 Instalando APK de Producción (6.7MB)..."

echo ""
echo "📦 Instalando APK $APK_TYPE..."
echo "   Archivo: $APK_PATH"

# Desinstalar versión anterior si existe
echo "🗑️  Desinstalando versión anterior (si existe)..."
adb uninstall co.edu.uniandes.miso.ux.flowbreak 2>/dev/null || true

# Instalar nueva versión
echo "⬇️  Instalando nueva versión..."
if adb install "$APK_PATH"; then
    echo ""
    echo "✅ ¡Instalación exitosa!"
    echo "   La aplicación FlowBreak Mobile ha sido instalada"
    echo "   Busca el ícono en tu dispositivo para abrirla"
    
    # Opcional: Abrir la aplicación automáticamente
    read -p "¿Deseas abrir la aplicación ahora? (y/n): " open_app
    if [[ $open_app =~ ^[Yy]$ ]]; then
        echo "🚀 Abriendo FlowBreak Mobile..."
        adb shell am start -n co.edu.uniandes.miso.ux.flowbreak/.MainActivity
    fi
else
    echo ""
    echo "❌ Error durante la instalación"
    echo "   Verifica que:"
    echo "   - La depuración USB esté habilitada"
    echo "   - El dispositivo tenga Android 8.1+ (API 27+)"
    echo "   - Haya suficiente espacio de almacenamiento"
    exit 1
fi

echo ""
echo "📋 Información de la aplicación:"
echo "   Nombre: FlowBreak Mobile"
echo "   Package: co.edu.uniandes.miso.ux.flowbreak"
echo "   Versión: 1.0"
echo "   APK: $(du -h "$APK_PATH" | cut -f1)"
echo "   Min SDK: Android 8.1 (API 27)"
echo "   Target SDK: Android 14 (API 36)"
echo ""
echo "💡 Comandos útiles:"
echo "   ./install-apk.sh --force    # Forzar reconstrucción"
echo "   adb logcat | grep FlowBreak # Ver logs de la app"
echo "   adb uninstall co.edu.uniandes.miso.ux.flowbreak # Desinstalar"
echo ""
echo "🎉 ¡Disfruta usando FlowBreak Mobile!"

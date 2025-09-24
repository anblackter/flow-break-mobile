# FlowBreak Mobile 📱

Una aplicación móvil Android desarrollada con **Jetpack Compose** para la gestión de alarmas y recordatorios inteligentes.

## 🚀 Características

- **Sistema de Login**: Autenticación con Google y Microsoft
- **Gestión de Alarmas**: Crear, editar y eliminar alarmas personalizadas
- **Grabación de Voz**: Integración de mensajes de voz para alarmas
- **Selector de Tiempo**: Interfaz intuitiva para configurar horarios
- **Navegación Fluida**: Sistema de navegación basado en estados
- **Animaciones**: Efectos visuales suaves y profesionales
- **UI Moderna**: Diseño Material Design 3 con tema personalizado

## 🛠️ Tecnologías Utilizadas

- **Kotlin** - Lenguaje de programación principal
- **Jetpack Compose** - Framework de UI moderna
- **Material Design 3** - Sistema de diseño
- **Android Gradle Plugin** - Sistema de construcción
- **Compose Navigation** - Navegación entre pantallas

## 📋 Requisitos del Sistema

### Para Desarrollo:
- **Android Studio** Hedgehog (2023.1.1) o superior
- **JDK 17** o superior
- **Android SDK** con API Level 34
- **Gradle 8.0** o superior

### Para Instalación:
- **Android** API Level 27 (Android 8.1) o superior
- **RAM**: Mínimo 2GB recomendado
- **Almacenamiento**: 50MB libres

## 🚀 Inicio Rápido

### Instalación Directa (Solo APK)
```bash
# 1. Clonar repositorio
git clone https://github.com/anblackter/flow-break-mobile
cd flow-break-mobile

# 2. Conectar dispositivo Android y ejecutar
./install-apk.sh
```

## 🔧 Configuración para Desarrollo

### 1. Clonar el Repositorio
```bash
git clone https://github.com/anblackter/flow-break-mobile
cd flow-break-mobile
```

### 2. Abrir en Android Studio
1. Abre **Android Studio**
2. Selecciona **"Open an existing project"**
3. Navega hasta la carpeta del proyecto y selecciónala
4. Espera a que Gradle sincronice las dependencias

### 3. Configurar el SDK
1. Ve a **File → Project Structure**
2. En **Project Settings → Project**, asegúrate de que:
   - **Gradle Version**: 8.0 o superior
   - **Android Gradle Plugin Version**: 8.1.0 o superior
3. En **SDK Location**, verifica que tengas instalado:
   - **Android SDK Platform 34**
   - **Android SDK Build-Tools 34.0.0**

### 4. Sincronizar Dependencias
```bash
# En la terminal de Android Studio o terminal del sistema:
./gradlew clean
./gradlew build
```

## 🎨 Previsualización de Pantallas

### Usando Android Studio Previews

1. **Navegar a los Componentes**:
   ```
   app/src/main/java/co/edu/uniandes/miso/ux/flowbreak/MainActivity.kt
   ```

2. **Ver Previews Disponibles**:
   - `LoginDisplayPreview()` - Pantalla de login
   - `HomeDisplayPreview()` - Pantalla principal
   - `CreateAlarmScreenPreview()` - Creación de alarmas
   - `RecordVoiceDisplayPreview()` - Grabación de voz
   - `DeleteAlarmDisplayPreview()` - Confirmación de eliminación
   - `TimePickerCreateAlarmDisplayPreview()` - Selector de tiempo
   - `LoadingDisplayPreview()` - Pantalla de carga

3. **Activar la Vista Previa**:
   - Abre `MainActivity.kt`
   - En el panel derecho, haz clic en **"Split"** o **"Design"**
   - Verás todas las previews renderizadas en tiempo real

4. **Interactuar con las Previews**:
   - Haz clic en el ícono de **"Interactive Mode"** (▶️) en cada preview
   - Prueba la navegación y interacciones básicas
   - Usa el **"Device Preview"** para ver en diferentes tamaños de pantalla

### Componentes Individuales

También puedes previsualizar componentes individuales en:
```
app/src/main/java/co/edu/uniandes/miso/ux/flowbreak/ui/components/Components.kt
```

Previews disponibles:
- `LoginButtonPreview()` - Botones de login
- `AddAlarmButtonPreview()` - Botón flotante de agregar
- `MainToolBarPreview()` - Barra de herramientas principal
- `ListItemAlarmPreview()` - Items de lista de alarmas
- `TimePickerAlarmPreview()` - Selector de tiempo
- `DayCheckBoxAlarmPreview()` - Checkboxes de días
- `TypeAlarmButtonPreview()` - Botones de tipo de alarma
- `AlarmCreationButtonsPreview()` - Botones de creación
- `AlertDialogDeleteAlarmPreview()` - Diálogo de eliminación

## 📱 Ejecutar la Aplicación

### En Emulador
1. **Crear un AVD** (Android Virtual Device):
   - Ve a **Tools → AVD Manager**
   - Crea un nuevo dispositivo virtual con **API 27+**
   - Recomendado: **Pixel 6** con **Android 13 (API 33)**

2. **Ejecutar**:
   - Haz clic en el botón **"Run"** (▶️) en Android Studio
   - O usa el atajo: `Shift + F10`

### En Dispositivo Físico
1. **Habilitar Opciones de Desarrollador**:
   - Ve a **Configuración → Acerca del teléfono**
   - Toca **"Número de compilación"** 7 veces
   - Regresa y ve a **Opciones de desarrollador**
   - Activa **"Depuración USB"**

2. **Conectar y Ejecutar**:
   - Conecta tu dispositivo via USB
   - Autoriza la depuración USB
   - Selecciona tu dispositivo en Android Studio
   - Haz clic en **"Run"**

### Generar APK
```bash
# Limpiar y generar APK de producción
./gradlew clean assembleRelease
```

### Instalación del APK

#### Método 1: Script Automático con Construcción (Recomendado)
```bash
# Construcción inteligente e instalación
./install-apk.sh

# Forzar reconstrucción completa e instalación
./install-apk.sh --force
```

## 🗂️ Estructura del Proyecto

```
app/
├── src/main/
│   ├── java/co/edu/uniandes/miso/ux/flowbreak/
│   │   ├── MainActivity.kt              # Actividad principal y pantallas
│   │   └── ui/
│   │       ├── components/
│   │       │   └── Components.kt        # Componentes reutilizables
│   │       └── theme/
│   │           ├── Color.kt            # Paleta de colores
│   │           ├── Theme.kt            # Configuración del tema
│   │           └── Type.kt             # Tipografía
│   └── res/
│       ├── drawable/                   # Iconos e imágenes
│       ├── values/
│       │   ├── colors.xml             # Colores adicionales
│       │   └── strings.xml            # Textos de la aplicación
│       └── mipmap/                    # Iconos de la app
├── build.gradle.kts                   # Configuración de Gradle del módulo
└── proguard-rules.pro                # Reglas de ofuscación
```

### Pantallas Principales:
1. **Login**: Autenticación con proveedores externos
2. **Home**: Lista de alarmas existentes
3. **Create Alarm**: Configuración de nuevas alarmas
4. **Voice Recorder**: Grabación de mensajes personalizados
5. **Time Picker**: Selección de horarios
6. **Delete Dialog**: Confirmación de eliminación

## 📊 Detalles Técnicos

### Configuración de Build
```kotlin
android {
    compileSdk = 36
    defaultConfig {
        applicationId = "co.edu.uniandes.miso.ux.flowbreak"
        minSdk = 27
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"
    }
}
```

### Dependencias Principales
- **Jetpack Compose**: Framework de UI moderna
- **Material Design 3**: Componentes de diseño
- **Kotlin**: Lenguaje principal
- **AndroidX**: Bibliotecas de soporte modernas

### Personalización del Tema
- `ui/theme/Color.kt` - Paleta de colores FlowBreak
- `ui/theme/Theme.kt` - Configuración Material Design 3
- **Primary**: Azul FlowBreak (`FB_Light_Primary50`)
- **Background**: Imagen de fondo personalizada
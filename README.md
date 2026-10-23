# Sistema de Cajero Automático 🏦

Este proyecto es una aplicación de consola en Java que simula las funciones de un cajero automático. El archivo fuente principal es `bienvenida.java` y ha sido empaquetado en un archivo ejecutable `.jar`.

## 📋 Requisitos Previos

Antes de ejecutar el programa, asegúrate de tener instalado el **Java Development Kit (JDK)** o el **Java Runtime Environment (JRE)** versión 8 o superior en tu sistema.

Para verificar si tienes Java instalado, abre una terminal y ejecuta:
```bash
java -version
```

## 🚀 Instrucciones de Ejecución

Tienes dos formas de ejecutar esta aplicación en Windows:

### Opción 1: Usando el acceso rápido (`.bat`)
Si estás en Windows, la forma más sencilla es usar el script automatizado:
1. Asegúrate de que `Cajero.bat` y `Cajero.jar` estén en la misma carpeta.
2. Haz **doble clic** sobre el archivo `Cajero.bat`.

### Opción 2: Desde la terminal de comandos (CMD o PowerShell)
1. Abre la terminal y navega hasta la carpeta donde se encuentra el archivo `.jar`.
2. Ejecuta el siguiente comando:
   ```bash
   java -jar Cajero.jar
   ```

---

## 🛠️ ¿Cómo volver a compilar y empaquetar el código? (Opcional)

Si realizas cambios en el código fuente `bienvenida.java` y deseas generar un nuevo archivo `cajero.jar`, sigue estos pasos en la terminal:

1. **Compilar el código fuente:**
   ```bash
   javac bienvenida.java
   ```
   *(Esto generará el archivo `bienvenida.class`)*

2. **Empaquetar el nuevo JAR:**
   ```bash
   jar -cfe cajero.jar bienvenida bienvenida.class
   ```

---
Desarrollado con ☕ en Java por César Luna.

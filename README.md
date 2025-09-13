# 🔗 Acortador de URLs

Un acortador de URLs moderno desarrollado con **Spring Boot** (backend) y **React** (frontend), que permite convertir URLs largas en enlaces cortos y manejables.

## ✨ Características

- **Acortamiento de URLs**: Convierte URLs largas en enlaces cortos de 6 caracteres
- **Redirección automática**: Los enlaces cortos redirigen automáticamente a la URL original
- **Interfaz moderna**: UI limpia y responsiva desarrollada con React
- **API RESTful**: Backend robusto con Spring Boot
- **CORS habilitado**: Comunicación fluida entre frontend y backend
- **Almacenamiento en memoria**: Almacenamiento temporal de URLs (ideal para desarrollo)

## 🛠️ Tecnologías Utilizadas

### Backend
- **Java 21**
- **Spring Boot 3.5.5**
- **Spring Web**
- **Maven**

### Frontend
- **React 19.1.1**
- **Vite 7.1.2**
- **ESLint**

## 📁 Estructura del Proyecto

```
acortadorURL/
├── backend/
│   └── shortenurl/
│       ├── src/main/java/com/cesar/shortenurl/
│       │   ├── controllers/
│       │   │   └── ShortenController.java
│       │   ├── service/
│       │   │   └── ShortenServiceImpl.java
│       │   └── ShortenurlApplication.java
│       └── pom.xml
└── fronted/
    └── short-url-ui/
        ├── src/
        │   ├── App.jsx
        │   └── main.jsx
        └── package.json
```

## 🚀 Instalación y Configuración

### Prerrequisitos
- Java 21 o superior
- Node.js 16 o superior
- Maven 3.6 o superior

### Backend (Spring Boot)

1. Navega al directorio del backend:
```bash
cd backend/shortenurl
```

2. Compila y ejecuta la aplicación:
```bash
./mvnw spring-boot:run
```

El backend estará disponible en: `http://localhost:8080`

### Frontend (React)

1. Navega al directorio del frontend:
```bash
cd fronted/short-url-ui
```

2. Instala las dependencias:
```bash
npm install
```

3. Ejecuta la aplicación en modo desarrollo:
```bash
npm run dev
```

El frontend estará disponible en: `http://localhost:5173`

## 📖 Uso

### Interfaz Web
1. Abre tu navegador y ve a `http://localhost:5173`
2. Ingresa la URL que deseas acortar
3. Haz clic en "Shorten"
4. Copia el enlace corto generado

### API REST

#### Acortar URL
```http
POST http://localhost:8080/api/shorten
Content-Type: application/json

{
  "url": "https://ejemplo.com/url-muy-larga"
}
```

**Respuesta:**
```json
{
  "shortUrl": "http://localhost:8080/abc123"
}
```

#### Redirección
```http
GET http://localhost:8080/{slugid}
```

## 🔧 Configuración

### Backend
- Puerto: `8080` (configurable en `application.properties`)
- CORS habilitado para `http://localhost:5173`

### Frontend
- Puerto: `5173` (configurable en `vite.config.js`)
- URL del backend: `http://localhost:8080`

## 🧪 Testing

### Backend
```bash
cd backend/shortenurl
./mvnw test
```

### Frontend
```bash
cd fronted/short-url-ui
npm run lint
```

## 📝 Notas de Desarrollo

- El almacenamiento actual es en memoria, por lo que las URLs se pierden al reiniciar el servidor
- Los slugs generados son de 6 caracteres alfanuméricos
- El proyecto está configurado para desarrollo local



## 📄 Licencia

Este proyecto está bajo la Licencia MIT. Ver el archivo `LICENSE` para más detalles.

## 👨‍💻 Autor

**César** - [@cesarguillermo](https://github.com/cesarguillermo)

---

⭐ ¡No olvides darle una estrella al proyecto si te gusta!

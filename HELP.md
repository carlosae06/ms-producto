# Comandos de Docker

A continuación se muestran los comandos utilizados para crear y ejecutar las imágenes de Docker para el microservicio de productos.

## Imagen Básica

Esta imagen se crea utilizando el archivo `Dockerfile`.

**Construir la imagen:**

```bash
docker build -t ms-producto .
```

**Ejecutar el contenedor:**

```bash
docker run -p 8080:8080 ms-producto
```

## Imagen con Script de Ejecución

Esta imagen se crea utilizando el archivo `Dockerfile_run` y el script `run.sh`.

**Construir la imagen:**

```bash
docker . build -f Dockerfile_run -t ms-producto-run .
```

**Ejecutar el contenedor:**


```bash
docker run -d --name ms-producto-02 -p 8083:8082 \
 -e URL=jdbc:postgresql://postgres-01:5432/curso \
 -e USER_DB=postgres \
 -e PASS_DB=123456 \
 -e PORT=8082 \
 --network curso_micro \
 ms-producto:5-run
```

## Comandos de Git Bash

**Por favor, añade aquí los comandos que tienes preparados en tu Git Bash.**

## Comandos para instalar Portainer
```bash
docker volume create portainer_data
```

```bash
docker run -d \
  -p 9443:9443 \
  -p 9000:9000 \
  --name portainer \
  --restart=always \
  -v portainer_data:/data \
  -v /var/run/docker.sock:/var/run/docker.sock \
  portainer/portainer-ce:latest
```

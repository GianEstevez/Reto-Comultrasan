# Use the official PostgreSQL image from Docker Hub
FROM postgres:latest

COPY init.sql /docker-entrypoint-initdb.d/

# Set environment variables for PostgreSQL
ENV POSTGRES_USER=root
ENV POSTGRES_PASSWORD=1234
ENV POSTGRES_DB=reto_comultrasan

# Expose the default PostgreSQL port
EXPOSE 5432

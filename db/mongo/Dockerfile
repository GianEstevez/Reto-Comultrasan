# Use the official MongoDB image from Docker Hub
FROM mongo:latest

COPY init.js /docker-entrypoint-initdb.d/

# Expose the default MongoDB port
EXPOSE 27017

# Set environment variables, if needed
ENV MONGO_INITDB_ROOT_USERNAME=root
ENV MONGO_INITDB_ROOT_PASSWORD=1234
ENV MONGO_INITDB_DATABASE=reto_comultrasan

# Copy any MongoDB configuration files, if required
# COPY mongod.conf /etc/mongod.conf

# Run MongoDB on container startup
CMD ["mongod"]

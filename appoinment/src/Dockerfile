# Use the official MySQL 8.0 image as the base
FROM mysql:8.0

# Set the root password for the MySQL instance
ENV MYSQL_ROOT_PASSWORD=brylle1234

# Create a new database
ENV MYSQL_DATABASE=user

# Set the user and password for the new database
ENV MYSQL_USER=username
ENV MYSQL_PASSWORD=password

# Copy the existing database data into the container
COPY sql/user_registration_routines.sql /docker-entrypoint-initdb.d/
COPY sql/user_registration_user_data.sql /docker-entrypoint-initdb.d/

# Expose the default MySQL port
EXPOSE 3306
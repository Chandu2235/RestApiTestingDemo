# Use official Maven image with JDK
FROM maven:3.9.4-eclipse-temurin-17

# Set working directory inside container
WORKDIR /app

# Copy all project files
COPY . .

# Optional: Download dependencies first
RUN mvn dependency:go-offline

# Run tests when container runs
CMD ["mvn", "clean", "test"]
# Expose port if needed (e.g., for web applications)
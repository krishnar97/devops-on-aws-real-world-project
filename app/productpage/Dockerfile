# BookNova - productpage service
# A simple, well-commented Dockerfile we explain step by step in the lecture.

# 1. Start from a small official Python image.
FROM python:3.13-slim

# 2. Set the working directory inside the container.
WORKDIR /app

# 3. Copy only the requirements first, so Docker can cache the install layer.
COPY requirements.txt ./

# 4. Install the Python dependencies (no cache = smaller image).
RUN pip install --no-cache-dir -r requirements.txt

# 5. Copy the rest of the application code.
COPY productpage.py ./
COPY templates ./templates

# 6. Document the port the app listens on.
EXPOSE 9080

# 7. Run as a non-root user for better security.
USER 1000

# 8. Start the app with gunicorn (a production web server).
CMD ["gunicorn", "-b", "0.0.0.0:9080", "productpage:app", "-w", "4"]

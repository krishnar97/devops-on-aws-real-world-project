# BookNova - details service (Ruby)

FROM ruby:3.3-slim

WORKDIR /app

# Copy the app code.
COPY details.rb ./

# The service listens on 7070.
EXPOSE 7070

# Run as a non-root user.
USER 1000

# Start the Ruby web service.
CMD ["ruby", "details.rb"]

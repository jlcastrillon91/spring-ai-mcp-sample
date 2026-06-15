#!/bin/bash

# Serve ollama in the background to pull the model properly
ollama serve &
# Wait for the server to be ready
sleep 5
# Pull the model
ollama pull granite4:3b
# Restart ollama server once the model has been pulled
pkill ollama && ollama serve
# spring-ai-mcp-sample

This is a simple Spring Boot project that demonstrates how to connect an **MCP Server and MCP Client** using **Spring AI**, **WebFlux**, and a local LLM (Ollama).

---

## 🚀 What this project does

This project shows how to build an AI system where:

- A user sends a prompt
- A local model (Ollama) processes the request
- The model can request tools when needed
- Tools are executed through an MCP Server
- Spring AI connects everything together
- WebFlux handles streaming communication

---

## 🧠 Main idea

The project is based on the **Model Context Protocol (MCP)**.

MCP is a standard way for AI models to use external tools.

It defines three main concepts:

- **Tools** → actions the model can execute
- **Resources** → data the model can read
- **Prompts** → reusable prompt templates

---

## 🏗️ Architecture
```md
User
  ↓
Ollama (LLM)
  ↓
Spring AI (Orchestration Layer)
  ↓
MCP Client
  ↓
MCP Server (Tools, Prompts, Resources)
  ↓
External Services / APIs
```

---

## ⚙️ Technologies used

- Spring Boot
- Spring AI (MCP support)
- WebFlux (streaming)
- Ollama (local LLM)
- MCP Java SDK

---

## ▶️ How it works

1. The user sends a prompt
2. Spring AI forwards it to the LLM (Ollama)
3. The model decides if a tool is needed
4. If yes, an MCP tool call is triggered
5. MCP Server executes the tool
6. The result is sent back to the model
7. The model returns the final answer

---

## 📌 Key takeaway

This project shows how to build a **modular AI system** where:

- The model is independent
- Tools are reusable
- Communication is standardized through MCP

---

## 🧪 Purpose of this project

This is a learning project to understand:

- MCP server/client communication
- Spring AI tool integration
- How local LLMs (Ollama) can use external tools
- Streaming responses with WebFlux

---

## 📖 Related concepts

- Model Context Protocol (MCP)
- Tool calling in LLMs
- Spring AI orchestration
- Local LLM deployment with Ollama
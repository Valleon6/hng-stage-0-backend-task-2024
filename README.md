# Public API for Basic Information

This API returns basic information including:
- Email address
- Current UTC datetime in ISO 8601 format
- GitHub repository URL

## API Endpoint

- **GET** `/`

### Response Format (200 OK)
```json
{
  "email": "val.ekechukwu@gmail.com",
  "current_datetime": "2025-01-30T09:30:00Z",
  "github_url": "https://github.com/valleon6/hng-stage-0-backend-task-2024.git"
}

### How to Run Locally

1.	Clone the repository:
bash
git clone https://github.com/valleon6/your-repo.git
cd your-repo

2.	Build the project using Maven:
bash:
./mvnw clean install

	3.	Run the project:
bash
./mvnw spring-boot:run

The API will be available at http://localhost:8080.

API Documentation
	•	Endpoint URL: /
	•	Request Format: No parameters required.
	•	Response Format: JSON containing email, current_datetime, and github_url.

Example Usage

To test the API, you can use curl or Postman:
curl http://localhost:8080/

{
  "email": "val.ekechukwu@gmail.com",
  "current_datetime": "2025-01-30T09:30:00Z",
  "github_url": "https://github.com/valleon6/hng-stage-0-backend-task-2024.git"
}

Related Links
	•	Hire Python Developers
	•	Hire C# Developers
	•	Hire Golang Developers
	•	Hire PHP Developers
	•	Hire Java Developers
	•	Hire Node.js Developers
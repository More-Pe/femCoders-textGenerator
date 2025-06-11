# 📝 Text Generator API

> A RESTful API built with **Java**, **Spring Boot**, and **Maven** to manage authors, categories, and phrases.

### ✨ Features

- 🔧 CRUD operations for Authors, Categories, and Phrases
- 🔗 Entity relationships:
    - An author has many phrases
    - A category has many phrases
    - A phrase belongs to one author and one category
- 🔄 JSON serialization optimized to avoid cycles
- 🗑️ Cascade delete and relationship management

### ⚙️ Stack

<p align="center">
  <a href="https://skillicons.dev">
    <img src="https://skillicons.dev/icons?i=java,spring,maven" />
  </a>
</p>


### 🗄️ Database Design

![Database Design](assets/DB_schema.jpeg)

#### Relationships
- **Author** 1:N **Phrase** (One author has many phrases)
- **Category** 1:N **Phrase** (One category has many phrases)
- **Phrase** N:1 **Author** (One phrase belongs to one author)
- **Phrase** N:1 **Category** (One phrase belongs to one category)

### 🌐 Endpoints

<details>
<summary>👨‍💼 Authors</summary>

| Method | URI             | Action                    | Status Codes             | Body Example |
|--------|-----------------|---------------------------|--------------------------|--------------|
| GET    | /authors        | List all authors          | 200 OK                   | N/A          |
| GET    | /author/{id}    | Get author by ID          | 200 OK, 404 Not Found   | N/A          |
| POST   | /author         | Create author             | 201 Created              | `{ "name": "Gabriel García Márquez" }` |
| PUT    | /author/{id}    | Update author (full)      | 200 OK, 404 Not Found   | `{ "name": "Mario Vargas Llosa" }` |
| DELETE | /author/{id}    | Delete author             | 204 No Content          | N/A          |

</details>

<details>
<summary>🏷️ Categories</summary>

| Method | URI               | Action                        | Status Codes             | Body Example |
|--------|-------------------|-------------------------------|--------------------------|--------------|
| GET    | /categories       | List all categories           | 200 OK                   | N/A          |
| GET    | /category/{id}    | Get category by ID            | 200 OK, 404 Not Found   | N/A          |
| POST   | /category         | Create category               | 201 Created              | `{ "name": "Reflection" }` |
| PUT    | /category/{id}    | Update category (full)        | 200 OK, 404 Not Found   | `{ "name": "Philosophy" }` |
| DELETE | /category/{id}    | Delete category               | 204 No Content          | N/A          |

</details>

<details>
<summary>💭 Phrases</summary>

| Method | URI             | Action                         | Status Codes             | Body Example |
|--------|-----------------|--------------------------------|--------------------------|--------------|
| GET    | /phrases        | List all phrases               | 200 OK                   | N/A          |
| GET    | /phrase/{id}    | Get phrase by ID               | 200 OK, 404 Not Found   | N/A          |
| POST   | /phrase         | Create phrase                  | 201 Created              | `{ "text": "Life is beautiful", "author": { "id": 1 }, "category": { "id": 2 } }` |
| PATCH  | /phrase/{id}    | Update phrase (partial)        | 200 OK, 404 Not Found   | `{ "text": "New text" }` |
| DELETE | /phrase/{id}    | Delete phrase                  | 204 No Content          | N/A          |

</details>

### 📊 HTTP Status Codes Used

#### ✅ Success Codes
- **200 OK** - Successful operation (GET, PUT, PATCH)
- **201 Created** - Resource successfully created (POST)
- **204 No Content** - Successful deletion (DELETE)

#### ❌ Error Codes
- **400 Bad Request** - Invalid data in request
- **404 Not Found** - Resource not found
- **409 Conflict** - Conflict with current state (resource already exists)

#### 📝 Important Notes

- ⚠️ **Cascade Delete**: Deleting authors or categories will also delete their associated phrases
- 🔄 **PATCH Endpoint**: The `PATCH /phrase/{id}` endpoint allows partial updates (only fields sent in the body are updated)
- 🔒 **Cycle Prevention**: JSON serialization is optimized to avoid circular references
- ✅ **Validation**: All endpoints include input data validation

### 📞 Contact

<a href=https://www.linkedin.com/in/morena-peralta-almada target="blank">![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)</a> <a href=https://www.github.com/More-Pe target="blank">![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)</a>

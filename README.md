# Catalog app
## System Environments

| Name | Description |
| --- | --- |
|DB_USERNAME|Postgres username|
|DB_PASSWORD|Postgres password|
|DB_URL|Postgres db url|

## API
### Get products

Method: **GET** \
***${appUrl}/product***

**Params:** \
*sectionId* - section id (type: uuid, required: false)  \
*name* - product name (type: string, required: false, substr, case-sensitive) \
*minPrice* - product minimum price (type: double, required: false) \
*maxPrice* - product maximum price (type: double, required: false)

with pagination

### Get product

Method: **GET** \
***${appUrl}/product/${id}***

**Path variables:** \
*id* - product id (type: uuid, required: true)  \

### Create/Update product

Method: **POST** \
***${appUrl}/product***

**Body:**
```json
{
  "name": "Product name",
  "price": 30.12,
  "sectionId": "67dc04a3-ab10-4136-8a24-ec615cf7a3fe"
}
```

### Delete product

Method: **DELETE** \
***${appUrl}/product/${id}***
                    
**Path variables:** \
*id* - product id (type: uuid, required: true)  \

### Get sections

Method: **GET** \
***${appUrl}/section***

**Params:** \
*parentId* - parent section id (type: uuid, required: true)

without pagination

### Get section

Method: **GET** \
***${appUrl}/section/${id}***

**Path variables:** \
*id* - section id (type: uuid, required: true)  \

### Create/Update section

Method: **POST** \
***${appUrl}/section***

**Body:**
```json
{
  "name": "Section name",
  "parentId": "67dc04a3-ab10-4136-8a24-ec615cf7a3fe"
}
```

### Delete section

Method: **DELETE** \
***${appUrl}/section/${id}***
                    
**Path variables:** \
*id* - section id (type: uuid, required: true)  \

cascade delete all dependent products
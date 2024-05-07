
# WayCourier Project

## Overview

WayCourier is a Spring Boot backend project aimed at allowing users to deliver packages while on scheduled rides to a destination. Users can request new package deliveries and manage existing ones through various endpoints.

## API Reference

```http
  POST /api/packages
```

 ####  Creates a new package request.
 | Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `Package` | `JSON Object` | **Required**. The package entity which needs to be created. |

   ```json
   {
      "deliveryAddress": "Address of the recipient",
      "packageName": "Type/ANy name of the package",
      "location": {
          "lat": "latitude",
          "lng": "longitude"
      },
      "recptMobNo": "Recipient mobile number",
      "fragile": "Boolean value true/false",
      "username": "Username of the user who is creating the package request"
  }
```

```http
  GET /api/packages/{pkgId}
```
####  Fetch the package details for the pkgId provided.
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `pkgId`      | `string` | **Required**. Id of pakcage to fetch |

#### Response Body (200)
```json
   {
       "pkg_id": "Package ID",
       "pkgAddress": "Full Address of the package",
       "recptMobNo": "Recipient Mobile no",
       "pkgLongitude": "Delivery point longitude",
       "pkgLatitude": "Delivery point latitude",
       "pkgStatus": "Package status",
       "recEndDate": "End date of the package",
       "createdAt": "Package creation date",
       "fragile": "Fragile package or not",
       "username": "Whom's package"
   }
```
```http
  POST /api/packages/update
```
| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `Package` | `JSON Object` | **Required**. The package entity which needs to be updated. |

```json
   {
      "package": "package ID"
      "recptMobNo": "Recipient mobile number",
      "fragile": "Boolean value true/false",
      "pkgStatus": "IN_TRANSIT/	DELIVERED/ ACCEPTED/ NOT_ACCEPTED/ CANCELLED/ CREATED"
  }
```
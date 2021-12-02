## Tencnologías a usar:
- Java
- Gradle version
- Spring Boot
- IDE: IntelliJ

## Problema
El ejemplo busca automatizar el comportamiento de un bibliotecario cuando un usuario
desea prestar un libro.

Un préstamo es representado en nuestro negocio por los siguientes atributos

**isbn**: identificador único de un libro (campo alfanumérico de máximo 10 dígitos)  
**identificacionUsuario**: número de la identificación del usuario (campo alfanumérico de maximo 10 digitos)  
**tipoUsuario**: determina la relación que tiene el usuario con la biblioteca, corresponde a un campo que puede tener solo alguno de los siguientes dígitos numérico
1. usuario afilado
2. usuario empleado de la biblioteca
3. usuario invitado

## Objetivo
Crear una API tipo REST la cual permita llevar a cabo las siguientes funcionalidades
1. El Path debe ser `/prestamo`  y el método HTTP tipo **POST**: permite crear un prestamo con las siguientes validaciones
    1. Un usuario invitado solo puede tener un libro prestado en la biblioteca, si un usuario invitado intenta prestar más de un libro debería retornar un error HTTP 400 con el siguiente json.  
       **Para verificar si un usuario ya tiene un préstamo se debe usar el campo _identificacionUsuario_**
        ```json
            {
             "mensaje" : "El usuario con identificación xxxxxx ya tiene un libro prestado por lo cual no se le puede realizar otro préstamo"
            }
        ```       
       Donde **xxxxxx** corresponde a la identificación del usuario que intenta hacer el prestamo
    2. Al momento de realizar el préstamo se debe hacer el cálculo de la fecha máxima de devolución del libro, con la siguiente reglas de negocio
        1. Si el préstamo lo hace un usuario tipo **afiliado** la fecha de devolución debería ser la fecha actual más 10 días sin contar sábados y domingos
        2. Si el préstamo lo hace un usuario tipo **empleado** la fecha de devolución debería ser la fecha actual más 8 días sin contar sábados y domingos
        3. Si el préstamo lo hace un usuario tipo **invitado** la fecha de devolución debería ser la fecha actual más 7 días sin contar sábados y domingos  
           **Esta fecha deberá ser almacenada en la base de datos junto con toda la información del préstamo**
    3. Si en el campo **tipoUsuario** llega un valor diferente a los permitidos, deberá retornar un un error HTTP 400 con el siguiente JSON
         ```json
             {
               "mensaje" : "Tipo de usuario no permitido en la biblioteca"
             }
         ```
   **Ejemplo de petición y respuesta exitosa**  
   Petición  path: `/prestamo` método: **POST**
   ```json
    {
        "isbn":"DASD154212",
        "identificaciónUsuario":"154515485",
        "tipoUsuario":1
    }
    ```
   **Respuesta exitosa**
    ```json
        {
            "id": 1,
            "fechaMaximaDevolucion" : "15/02/2021"
        }
    ```
2. El path debe ser `/prestamo/{id-prestamo}` y el método HTTP tipo **GET**, donde la variable  {id-prestamo} corresponde al identificador con el cual se almacenó el préstamo en la base de datos, explicado en el primer punto.
   El siguiente es un ejemplo de petición y un ejemplo de cómo debería ser la respuesta en un caso exitoso  
   Petición  path: `/prestamo/1` método: **GET**
   ```json
        {
            "id": 1,	
            "isbn":"DASD154212",
            "identificaciónUsuario":"154515485",
            "tipoUsuario":1,
             "fechaMaximaDevolucion" : "15/02/2021"
        }
    ```
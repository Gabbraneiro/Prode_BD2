## Funcionalidad
| Endpoint | /partido/{partido}  |
| :------------ | :------------ |
| **Descripción ** |  Actualiza el resultado del partido con id {partido}|
| **Protocolo**  |  REST |
| **Método HTTP **| PUT  |
| **Datos de entrada**  |{golesLocal: int, golesVisitante: int, (opcional)penalesLocal: int, (opcional)penalesVisitante: int}|
| **Datos de salida**  |{id: int, local: JSON, visitante: JSON, torneo: JSON, fecha: string, golesLocal: int, golesVisitante: int, penalesLocal: int, penalesVisitante: int}|
| **Codigos de retorno** | 200, 404, 500 |
| **Tipo de retorno**  | JSON  |

| Endpoint | /apuesta/contabilizar  |
| :------------ | :------------ |
| **Descripción ** |  Hace el calculo de puntos de las apuestas de partidos terminados|
| **Protocolo**  |  REST |
| **Método HTTP **| POST  |
| **Datos de entrada**  |{}|
| **Datos de salida**  | [{id: int, golesLocal: int, golesVisitante: int, penalesLocal: int, penalesVisitante: int, partido: JSON, usuario: JSON, puntosGanados: int}, ...]|
| **Codigos de retorno** | 200, 404, 500 |
| **Tipo de retorno**  | JSON  |

| Endpoint | /puntajes  |
| :------------ | :------------ |
| **Descripción**  | Lista a los usuarios con sus respectivos puntajes. 
| **Protocolo**  |  REST |
| **Método HTTP** | GET  |
| **Datos de entrada**  | {}|
| **Datos de salida**  |[{username: string, puntaje: int} ]|
|** Codigos de retorno** | 201, 400, 500 |
| **Tipo de retorno**  | JSON  |

## CRUD

#### Torneo
| Endpoint | /torneo  |
| :------------ | :------------ |
| **Descripción**  |  Da de alta un torneo. 
| **Protocolo**  |  REST |
| **Método HTTP** | POST  |
| **Datos de entrada**  | {nombre: string }|
| **Datos de salida**  |{id: int, nombre: string} |
|** Codigos de retorno** | 201, 400, 500 |
| **Tipo de retorno**  | JSON  |

| Endpoint | /torneo  |
| :------------ | :------------ |
| **Descripción**  |  Lista todos los torneos  |
| **Protocolo**  |  REST |
| **Método HTTP** | GET  |
| **Datos de entrada**  |{}|
| **Datos de salida**  |[{id: int, nombre: string}, {id: int, nombre: string}, ...]|
| **Codigos de retorno** | 200, 500 |
| **Tipo de retorno**  | JSON  |

| Endpoint | /torneo/{torneo}  |
| :------------ | :------------ |
| **Descripción**  |  Obtiene un torneo con id {torneo}  |
| **Protocolo**  |  REST |
| **Método HTTP** | GET  |
| **Datos de entrada**  |{}|
| **Datos de salida**  |{id: int, nombre: string}|
|** Codigos de retorno** | 200, 404, 500 |
| **Tipo de retorno**  | JSON  |

| Endpoint | /torneo/{torneo}  |
| :------------ | :------------ |
| **Descripción ** |  Edita un torneo con id {torneo} |
| **Protocolo**  |  REST |
| **Método HTTP **| PATCH  |
| **Datos de entrada**  |{(opcional)nombre: string}|
| **Datos de salida**  |{id: int, nombre: string}|
| **Codigos de retorno** | 200, 404, 500 |
| **Tipo de retorno**  | JSON  |

| Endpoint | /torneo/{torneo}  |
| :------------ | :------------ |
| **Descripción**  |  Elimina el torneo con id {torneo} |
| **Protocolo**  |  REST |
| **Método HTTP **| DELETE  |
| **Datos de entrada**  |{"Se elimino correctamente"}|
| **Datos de salida**  |{}|
| **Codigos de retorno** | 200, 404, 500 |
| **Tipo de retorno**  | JSON  |

#### Equipo
| Endpoint | /equipo  |
| :------------ | :------------ |
| **Descripción**  |  Da de alta un equipo. 
| **Protocolo**  |  REST |
| **Método HTTP** | POST  |
| **Datos de entrada**  | {nombre: string }|
| **Datos de salida**  |{id: int, nombre: string} |
|** Codigos de retorno** | 201, 400, 500 |
| **Tipo de retorno**  | JSON  |

| Endpoint | /equipo  |
| :------------ | :------------ |
| **Descripción**  |  Lista todos los equipos  |
| **Protocolo**  |  REST |
| **Método HTTP** | GET  |
| **Datos de entrada**  |{}|
| **Datos de salida**  |[{id: int, nombre: string}, {id: int, nombre: string}, ...]|
| **Codigos de retorno** | 200, 500 |
| **Tipo de retorno**  | JSON  |

| Endpoint | /equipo/{equipo}  |
| :------------ | :------------ |
| **Descripción**  |  Obtiene un equipo con id {equipo}  |
| **Protocolo**  |  REST |
| **Método HTTP** | GET  |
| **Datos de entrada**  |{}|
| **Datos de salida**  |{id: int, nombre: string}|
|** Codigos de retorno** | 200, 404, 500 |
| **Tipo de retorno**  | JSON  |

| Endpoint | /equipo/{equipo}  |
| :------------ | :------------ |
| **Descripción ** |  Edita un equipo con id {equipo} |
| **Protocolo**  |  REST |
| **Método HTTP **| PATCH  |
| **Datos de entrada**  |{(opcional)nombre: string}|
| **Datos de salida**  |{id: int, nombre: string}|
| **Codigos de retorno** | 200, 404, 500 |
| **Tipo de retorno**  | JSON  |

| Endpoint | /torneo/{torneo}  |
| :------------ | :------------ |
| **Descripción**  |  Elimina el torneo con id {torneo} |
| **Protocolo**  |  REST |
| **Método HTTP **| DELETE  |
| **Datos de entrada**  |{"Se elimino correctamente"}|
| **Datos de salida**  |{}|
| **Codigos de retorno** | 200, 404, 500 |
| **Tipo de retorno**  | JSON  |

#### Usuario
| Endpoint | /usuario  |
| :------------ | :------------ |
| **Descripción**  |  Da de alta un usuario. 
| **Protocolo**  |  REST |
| **Método HTTP** | POST  |
| **Datos de entrada**  | {username: string, nombre: string, apellido: string }|
| **Datos de salida**  |{id: int, username: string, nombre: string, apellido: string} |
|** Codigos de retorno** | 201, 400, 500 |
| **Tipo de retorno**  | JSON  |

| Endpoint | /usuario  |
| :------------ | :------------ |
| **Descripción**  |  Lista todos los usuarios.
| **Protocolo**  |  REST |
| **Método HTTP** | GET  |
| **Datos de entrada**  |{}|
| **Datos de salida**  |[{id: int, username: string, nombre: string, apellido: string}, ...]|
| **Codigos de retorno** | 200, 500 |
| **Tipo de retorno**  | JSON  |

| Endpoint | /usuario/{usuario}  |
| :------------ | :------------ |
| **Descripción**  |  Obtiene un usuario con id {usuario}  |
| **Protocolo**  |  REST |
| **Método HTTP** | GET  |
| **Datos de entrada**  |{}|
| **Datos de salida**  |{id: int, username: string, nombre: string, apellido: string},|
|** Codigos de retorno** | 200, 404, 500 |
| **Tipo de retorno**  | JSON  |

| Endpoint | /usuario/{usuario}  |
| :------------ | :------------ |
| **Descripción ** |  Edita un usuario con id {usuario} |
| **Protocolo**  |  REST |
| **Método HTTP **| PATCH  |
| **Datos de entrada**  |{(opcional)username: string, (opcional)nombre: string, (opcional)apellido: string}|
| **Datos de salida**  |{id: int, username: string, nombre: string, apellido: string}|
| **Codigos de retorno** | 200, 404, 500 |
| **Tipo de retorno**  | JSON  |

| Endpoint | /usuario/{usuario}  |
| :------------ | :------------ |
| **Descripción**  |  Elimina el usuario con id {usuario} |
| **Protocolo**  |  REST |
| **Método HTTP **| DELETE  |
| **Datos de entrada**  |{}|
| **Datos de salida**  |{"Se elimino correctamente"}|
| **Codigos de retorno** | 200, 404, 500 |
| **Tipo de retorno**  | JSON  |

#### Partido
| Endpoint | /partido
| :------------ | :------------ |
| **Descripción**  |  Da de alta un partido. 
| **Protocolo**  |  REST |
| **Método HTTP** | POST  |
| **Datos de entrada**  | {local: int, visitante: int, torneo: int, fecha: string}  formato de fecha:  "2007-12-03T10:15:30"
| **Datos de salida**  |{id: int, local: JSON, visitante: JSON, torneo: JSON, fecha: string} |
|** Codigos de retorno** | 201, 400, 500 |
| **Tipo de retorno**  | JSON  |

| Endpoint | /partido  |
| :------------ | :------------ |
| **Descripción**  |  Lista todos los partidos.
| **Protocolo**  |  REST |
| **Método HTTP** | GET  |
| **Datos de entrada**  |{}|
| **Datos de salida**  |[{local: JSON, visitante: JSON, torneo: JSON, fecha: string, golesLocal: int, golesVisitante: int, penalesLocal: int, penalesVisitante: int}, ...]|
| **Codigos de retorno** | 200, 500 |
| **Tipo de retorno**  | JSON  |

| Endpoint | /partido/{partido}  |
| :------------ | :------------ |
| **Descripción**  |  Obtiene un partido con id {partido}  |
| **Protocolo**  |  REST |
| **Método HTTP** | GET  |
| **Datos de entrada**  |{}|
| **Datos de salida**  |{id: int, local: JSON, visitante: JSON, torneo: JSON, fecha: string, golesLocal: int, golesVisitante: int, penalesLocal: int, penalesVisitante: int},|
|** Codigos de retorno** | 200, 404, 500 |
| **Tipo de retorno**  | JSON  |

| Endpoint | /partido/{partido}  |
| :------------ | :------------ |
| **Descripción**  |  Elimina el partido con id {partido} |
| **Protocolo**  |  REST |
| **Método HTTP **| DELETE  |
| **Datos de entrada**  |{}|
| **Datos de salida**  |{"Se elimino correctamente"}|
| **Codigos de retorno** | 200, 404, 500 |
| **Tipo de retorno**  | JSON  |

#### Apuesta
| Endpoint | /apuesta
| :------------ | :------------ |
| **Descripción**  |  Da de alta un apuesta. 
| **Protocolo**  |  REST |
| **Método HTTP** | POST  |
| **Datos de entrada**  | {golesLocal: int, golesVisitante: int, penalesLocal: int, penalesVisitante: int, partido: int, usuario: int}
| **Datos de salida**  |{id: int, golesLocal: int, golesVisitante: int, penalesLocal: int, penalesVisitante: int, partido: JSON, usuario: JSON} |
|** Codigos de retorno** | 201, 400, 500 |
| **Tipo de retorno**  | JSON  |

| Endpoint | /apuesta  |
| :------------ | :------------ |
| **Descripción**  |  Lista todas las apuesta.
| **Protocolo**  |  REST |
| **Método HTTP** | GET  |
| **Datos de entrada**  |{}|
| **Datos de salida**  |[{id: int, golesLocal: int, golesVisitante: int, penalesLocal: int, penalesVisitante: int, partido: JSON, usuario: JSON}, ...]|
| **Codigos de retorno** | 200, 500 |
| **Tipo de retorno**  | JSON  |

| Endpoint | /apuesta/{apuesta}  |
| :------------ | :------------ |
| **Descripción**  |  Obtiene una apuesta con id {apuesta}  |
| **Protocolo**  |  REST |
| **Método HTTP** | GET  |
| **Datos de entrada**  |{}|
| **Datos de salida**  |{id: int, golesLocal: int, golesVisitante: int, penalesLocal: int, penalesVisitante: int, partido: JSON, usuario: JSON}|
|** Codigos de retorno** | 200, 404, 500 |
| **Tipo de retorno**  | JSON  |

| Endpoint | /apuesta/{apuesta}  |
| :------------ | :------------ |
| **Descripción**  |  Elimina la apuesta con id {apuesta} |
| **Protocolo**  |  REST |
| **Método HTTP **| DELETE  |
| **Datos de entrada**  |{}|
| **Datos de salida**  |{"Se elimino correctamente"}|
| **Codigos de retorno** | 200, 404, 500 |
| **Tipo de retorno**  | JSON  |



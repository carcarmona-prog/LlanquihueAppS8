👤 Autor del proyecto:

Carlos Estivens Carmona Barreto

Carrera:

Analista Programador Computacional.

Sede: Duoc uc sede online

📘 Descripción general del sistema LlanquihueTourAppS8: Esta semana mejoramos el programa con el sentido de fortalecer y darle una estructura más profesional y robusta, donde utilizamos instanceof para usar metodos especificos, tambien este sistema modular de gestión turística, que combina herencia, polimorfismo, interfaces y GUI para administrar servicios, colaboradores y recursos de manera clara y extensible.

1- Encapsulamiento de clases.

2- Herencia de clases.

3- Poliformismo.

4- Intarfaz de usuario.

5- Interfaces.

6- Instanceof

📁 src/
├── ui/                     # Interfaz gráfica y punto de entrada
│   ├── Frame.java          # Ventana principal con Swing
│   └── Main.java           # Clase principal con método main

├── model/                  # Clases de dominio
│   ├── ServicioTuristico.java
│   ├── ExcursionCultural.java
│   ├── PaseoLacustre.java
│   ├── RutaGastronomica.java
│   ├── ActivosVehiculos.java
│   ├── ColaboradoresExternos.java
│   ├── Personal.java
│   └── GuiasTuristicos.java

├── data/                   # Gestión de datos
│   ├── Gestor.java         # Clase genérica para manejar listas
│   └── GestorElementos.java# Gestor especializado con instanceof

├── service/                # Interfaces y contratos
│   ├── Registrable.java    # Interfaz común para entidades
│   └── InfoMostrable.java  # Interfaz para mostrar información

├── util/                   # Utilidades
│   └── Separador.java      # Clase auxiliar para separar/formatos



⚙️ Instrucciones para clonar y ejecutar el proyecto Clona el repositorio desde GitHub: git clone: https://github.com/carcarmona-prog/LlanquihueAppS8.git Abre el proyecto en IntelliJ IDEA.

Ejecuta el archivo Main.java desde el paquete ui.

Sigue las instrucciones en consola o en la interfaz gráfica (si corresponde).

Repositorio GitHub: https://github.com/carcarmona-prog/LlanquihueAppS8.git Fecha de entrega: 13/07/2026

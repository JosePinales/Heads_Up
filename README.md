# Heads_Up

Proyecto: Heads UP Game

Flujo básico del App Android:

1. Al abrir la aplicación muestra una pantalla de carga (splash screen).
2. El primer Activity (Pantalla) carga las categorías disponibles del juego (Tópicos como política, adivinanzas, deportes, acciones).
3. Cuando seleccione una de las categorías tiene un tiempo de preparación de 5 segundos (para que el usuario ponga el dispositivo en 
la frente), y luego muestra una palabra que el usuario debe de adivinar y empieza el temporizador de 1 minuto.
4. El jugador podrá adivinar tantas preguntas como pueda (cuando el usuario adivine una pregunta gira el dispositivo móvil hacia delante 
y si quiere pasar (bypass) la pregunta gira el dispositivo hacia atrás, siempre que el temporizador no llegue al tiempo límite (cero).
5. Cuando se acabe el tiempo, ignora la adivinanza actual, muestra un mensaje que dice que se acabó el tiempo y muestra la estadística 
de todas las adivinanzas que el usuario adivinó y las que fueron fallidas.
6. Al final el usuario puede decidir si volver a jugar esa misma categoría o cambiar de categoría.

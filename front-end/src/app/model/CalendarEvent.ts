export interface CalendarEvent {
  id: string; // Modifier le type de la propriété id
  title: string;
  start: Date;
  end: Date;
  // Autres propriétés de l'événement
}

// Utilisation du modèle CalendarEvent
const events: CalendarEvent[] = [
  {
    id: '1', // Utilisez des chaînes de caractères pour l'id
    title: 'Événement 1',
    start: new Date(),
    end: new Date(),
  },
  // Autres événements
];

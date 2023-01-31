<html lang='en'>
  <head>
    <meta charset='utf-8' />
    <script src='fullcalendar-6.0.3/dist/index.global.js'></script>
    <script>

      document.addEventListener('DOMContentLoaded', function() {
        var calendarEl = document.getElementById('calendar');
        var calendar = new FullCalendar.Calendar(calendarEl, {
          initialView: 'dayGridMonth'
        });
        calendar.render();
      });
      


    </script>

  </head>
  <body>
    <div id='calendar'></div>
  </body>
</html>
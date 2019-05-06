<%@page import="lombok.var"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<script
	src="https://cdn.jsdelivr.net/npm/moment@2.24.0/min/moment.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>
<script src="https://cdn.jsdelivr.net/npm/hammerjs@2.0.8"></script>
<script src="https://cdn.jsdelivr.net/npm/chartjs-plugin-zoom@0.7.0"></script>
<script
	src="https://cdn.jsdelivr.net/npm/chartjs-plugin-streaming@1.8.0"></script>
</head>
<body>
	<h1>Progess Managerment Of Project</h1>
	<div style="width: 60%">
		<canvas id="lineChart"></canvas>
	</div>

<!-- 	<script src="../../js/chart.js"></script> -->
<script>
  //line
  var ctxL = document.getElementById("lineChart").getContext('2d');
  var myLineChart = new Chart(ctxL, {
    type: 'line',
    data: {
      labels: ["tuần 1", "tuần 2", "tuần 3", "tuần 4", "tuần 5", "tuần 6", "tuần 7","tuần 8","tuần 9"],
      datasets: [{
          label: "Progess Excpect",
          data: [65, 59, 80, 81, 56, 55, 40,12,13],
          backgroundColor: [
            'rgba(105, 0, 132, .2)',
          ],
          borderColor: [
            'rgba(200, 99, 132, .7)',
          ],
          borderWidth: 2
        },
        {
          label: "Progess Actual",
          data: [28, 48, 40, 19, 86, 27, 90],
          backgroundColor: [
            'rgba(0, 137, 132, .2)',
          ],
          borderColor: [
            'rgba(0, 10, 130, .7)',
          ],
          borderWidth: 2
        }
      ]
    },
    options: {
      responsive: true
    }
  });

</script>
</body>
</html>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <!--h1>Hola Mundo</h1-->

    <?php
            $nombre = "Eloy";
            echo "<h1>Hola Mundo </h1>";
            echo "<h2>Mi nombre es: ".$nombre. "</h2>";
            // define("PI", 3.14);
            const PI=3.14;
            echo "<h3>El area de un circulo con radio 2m es: ".(PI*2)."m</h3>";

            $n = 3;
            if($n<=4 && 2==2)
                echo "<p>".$n." es menor o igual que 4</p>";
            elseif($n<=7)
                echo "<p>".$n." es menor o igual que 7</p>";
            else if($n<=10)
                echo "<p>".$n." es menor o igual que 10</p>";
            else
                echo "<p>".$n." es mayor que 10</p>";

            echo "<p>El valor de n es igual a :".$n."</p>"
    ?>
</body>
</html>

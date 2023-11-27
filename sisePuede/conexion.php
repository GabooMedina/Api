<?php

class Conexion{

public function conectar(){

define("host","localhost");
define("user","root");
define("bd","almacen");
define("psw","");

$ops=array(PDO::MYSQL_ATTR_INIT_COMMAND>"SETNAMES utf8");

try {
    $conexion= new PDO("mysql:host=".host.";dbname=".bd,user,psw,$ops);
    return $conexion;
} catch (PDOException $e) {
echo($e->getMessage());
}

}

}
?>
<?php

include_once("conexion.php");

class CRUD{

public static function obtenerEstudiante($nombre,$direccion){

$objeto= new Conexion();
$conectar = $objeto->conectar();

$sql="SELECT* FROM productos WHERE cod_bodega=(SELECT codigo FROM bodegas WHERE nombre='$nombre' AND direccion='$direccion')";

$resultado = $conectar->prepare($sql);
$resultado->execute();
$dato = $resultado->fetchAll(PDO::FETCH_ASSOC);
echo json_encode($dato);

}

}

?>
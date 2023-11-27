<?php

include_once("conexion.php");

class CRUDelimnar{

public static function eliminar($codigo){

$objeto=new Conexion();
$conectar=$objeto->conectar();

$sql=" DELETE FROM productos WHERE codigo='$codigo'";

$resultado=$conectar->prepare($sql);
$resultado->execute();
$data=$resultado->fetchAll(PDO::FETCH_ASSOC);
$conectar->commit();
echo(json_encode($data));
}

}

?>
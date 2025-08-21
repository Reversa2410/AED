//Escribe  un programa que almacene en una arreglo ordenado el nombre y el salario de un grupo de empleados y realice las siguientes operaciones:
//1. Dar de alta a un empleado
//2. Dar de baja a un empleado
//3. modificar el salario de un empleado
//4. Imprimir un registro determinado
//5. Imprimir todos los registros
//6. Salir

import javax.swing.*;
public class Empleados
{

        public static void main(String args[])
        {
                int tam = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de empleados: "));
                String nombre[] = new String[tam];
                int salario[] = new int[tam];
                int opc, n=-1;
                do {
                        opc = Integer.parseInt(JOptionPane.showInputDialog("\t *Registro Empleados* \n 1. Dar de alta a un empleado \n 2. Dar de baja a un empleado \n 3. Modificar el salario de un empleado \n 4. Imprimir registros determinados \n 5. Imprimir todos los registros \n 6. Salir" ));
                        switch (opc)
                        {
                                case 1:
                                        n = Inserta(nombre, salario, n, tam);
                                        break;
                                case 2:
                                        n = Eliminar(nombre, salario, n);
                                        break;
                                case 3:
                                        Modificar(nombre, salario, n);
                                        break;
                                case 4:
                                        ImprimirUno(nombre, salario, n);
                                        break;
                                case 5:
                                        ImprimirTodo(nombre, salario, n);
                                        break;
                                case 6:
                                        break;
                                default:
                                        JOptionPane.showMessageDialog(null, "Opcion no valida...");
                        }//fin del switch
                }while (opc != 6);
                System.exit(0);
        }

        public static int Inserta(String nombre[], int salario[], int n, int tam)
        {
                if(n == -1)
                {
                        n++;
                        nombre[n] = JOptionPane.showInputDialog("Ingrese el nombre:  ");
                        salario[n] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el salario: "));
                }//cierre del if
                else if (n < (tam-1)) {
                        String nomB = JOptionPane.showInputDialog("Ingrese el nombre: ");
                        int pos = Busca(nombre, nomB, n);
                        if((pos >= 0) && (pos == 0) && (nomB.equalsIgnoreCase(nombre[0])));
                        {
                                JOptionPane.showMessageDialog(null, "Dato existente");
                        }
                        else{
                                n = n+1;
                                pos = pos *(-1);
                                for (int i = n; i < (pos+1); i--) {
                                        nombre[i] = nombre[i-1];
                                        salario[i] = salario[i-1];
                                }
                                nombre[pos] = nomB;
                                salario[pos] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el salario: "));


                        }//else
                }//else if

                else {
                        JOptionPane.showMessageDialog(null, "No hay espacio");
                        return n;
                }
        }//metodo

        public static int Eliminar(String nombre[], int salario[], int n)
        {
                if(n>-1)
                {
                        String nomB = JOptionPane.showInputDialog("Ingrese a la persona a buscar: ");
                        int pos = Busca(nombre, nomB, n);
                        JOptionPane.showMessageDialog(null, "Pos = "+pos);
                        if(pos < 0)
                        {
                                JOptionPane.showMessageDialog(null, "El dato no existe");
                        }
                        else {
                                n = n-1;
                                for (int i = pos; i < n; i++) {
                                        nombre[i] = nombre[i+1];
                                        salario[i] = salario[i+1];
                                }//for
                                JOptionPane.showMessageDialog(null, "Eliminacion realizada");
                        }//else
                }//if
                else {
                        JOptionPane.showMessageDialog(null, "Arreglo vacio");
                        return n;
                }
        }//metodo eliminar

        public static void Modificar(String nombre[], int salario[], int n)
        {
                if(n >-1)
                {
                        String nomB = JOptionPane.showInputDialog("Ingrese el nombre: ");
                        int pos = Busca(nombre, nomB, n);
                        if(pos < 0)
                        {
                                JOptionPane.showMessageDialog(null, "No existe" + nomB);
                        }
                        else {
                                salario[pos] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo salario: "));
                                JOptionPane.showMessageDialog(null, "Modificacion realizada");
                        }//else
                }//if
                else {
                        JOptionPane.showMessageDialog(null, "Arreglo vacio");
                }
        }//metodo eliminar

        public static void ImprimirUno(String nombre[], int salario[], int n)
        {
                if (n>1)
                {
                        String nomB = JOptionPane.showInputDialog("Ingrese el nombre a buscar: ");
                        int pos = Busca(nombre, nomB, n);
                        if(pos < 0)
                        {
                                JOptionPane.showMessageDialog(null, "No existe "+ nomB);
                        }
                        else {
                                JOptionPane.showMessageDialog(null, "Nombre empleado: " + nombre[pos] + "\n Salario:  " + salario[pos] + "\n");
                        }
                }//cierre del if
                else {
                        JOptionPane.showMessageDialog(null, "arreglo vacio");

                }//cierre metodo
        }

        //TODO -> opcion 5, imprimir todos los registros
        //TOOD -> metodo "Busca"




}//clase
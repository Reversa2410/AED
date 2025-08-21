//código

import javax.swing. *;
public class Docentes
{
    public static void main (String args[]) {
        int tam = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tam del arreglo: "));

        String nomb[] = new String[tam];
        String direc[] = new String[tam];
        String cedula[] = new String[tam];
        int opcion, n = -1;

        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("*****Registro Docente***** \n 1. Dar de Alta. \n 2. Dar de baja. \n 3. Modificar la direccion. \n 4. Imprimir todos los registros. \n 5. Salir."));
            switch (opcion)
            {
                case 1:
                    n = InsertarDesordenado(nomb, direc, cedula, n, tam);
                    break;
                case 2:
                    n = EliminaDesordenado(nomb, direc, cedula, n);
                    break;
                case 3:
                    ModificarDesordenado(nomb, direc, n);
                    break;
                case 4:
                    Imprimir(nomb, direc, cedula, n);
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Saliendo del programa...");
                    break;
            }//termina el switch

        } //fin del do
        while (opcion != 5);
        System.exit(0);

    }//termina el main

    public static int InsertarDesordenado(String nomb[], String direc[], String cedula[], int n, int tam)
    {
        if (n < tam -1)
        {
            n++;
            nomb[n] = JOptionPane.showInputDialog("Ingrese el nombre: ");
            direc[n] = JOptionPane.showInputDialog("Ingrese la direccion: ");
            cedula[n] = JOptionPane.showInputDialog("Ingrese Cedula (incluyendo guiones): ");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "No hay espacio");

        }
        return n;
    }//metodo

    public static int EliminaDesordenado(String nomb[], String direc[], String cedula[], int n)
    {
        String nombreB = JOptionPane.showInputDialog("Ingrese el nombre a buscar: ");
        int i = 0;
        while(( i <= 0) && (!nombreB.equalsIgnoreCase(nomb[i])))
            i++;
        if (i > n)
        {
            JOptionPane.showMessageDialog(null, "Elemento no encontrado");
        }
        else
        {
            for (int k = i; k <= n-1; k++)
            {
                nomb[k] = nomb[k+1];
                direc[k] = direc[k+1];
                cedula[k] = cedula[k+1];
            }
            n--;
        }//fin del else

        return n;
    }//fin del metodo

    public static int ModificarDesordenado(String nomb[], String direc[], int n)
    {
        String nombB = JOptionPane.showInputDialog("Ingrese el nombre a buscar: ");
        int i = 0;
        while((i<= 0) && (!(nombB.equalsIgnoreCase(nomb[i]))))
            i++;
        if(i > n)
        {
            JOptionPane.showMessageDialog(null, "No se ha encontrado. ");
        }
        else {
            direc[i] = JOptionPane.showInputDialog("Ingrese nueva direccion: ");
        }
        return n;
    }//fin del metod

    public static void Imprimir(String nomb[], String direc[], String cedula[], int n)
    {
        String salida = "Nombre del docente \t\t Direccion \t\t N. Cedula \n";
        for(int i = 0; i <= n; i++)
        {
            salida += nomb[i] + "\t\t" + direc[i] + "\t\t" + cedula[i]+ "\n";
            JTextArea imp = new JTextArea();
            imp.setEditable(false);
            imp.setText(salida);
            JOptionPane.showMessageDialog(null, imp);
        }
    }//fin del metodo


}//fin de la clase
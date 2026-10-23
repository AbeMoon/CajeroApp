import java.util.Scanner;

public class Bienvenida {
    public static void main(String[] args) {
        //Inicialización del Scanner para la entrada de datos
        Scanner sc = new Scanner(System.in);

        //Declaración de constantes
        final String NOMBRE_BANCO = "InnBank";
        //final String CONTRA = "Sabado";

        // "Base de datos de usuarios"
        
        String[] NOMBRES = {"Ana","Luis", "Sofia"};
        String[] pines = {"1234", "5678", "9012"};
        double[] saldos = {1500.00, 320.50, 8000.00};

        //Declaración de variables
        String nombreUsuario, contra2 = "";
        double deposito, retiro, transferencia;
        int intentos = 3, opcion = 1, pos = 0, pos2 = -1, pos1 = -1;


        do{
            pos = -1;

            System.out.printf("Bienvenido a %s, ¿Cual es tu nombre?: ", NOMBRE_BANCO);
            nombreUsuario   = sc.nextLine();

            for(int i = 0; i < NOMBRES.length; i++){
                if(nombreUsuario.equals(NOMBRES[i])){
                    pos = i;
                } 
            }
            
            if( pos == -1){
                System.out.print("\nError nombre de usuario invalido\n\n");
            }
            
        }while (pos == -1);

        if(pos != -1){
            do{
                System.out.printf("\n%s, para acceder deme su contrasenia: ", NOMBRES[pos]);
                contra2  = sc.nextLine();
                if(pines[pos].equals(contra2)){
                    System.out.print("\n\nAcceso concedido\n\n");
                   break;
                 }else{
                    intentos--;
                    System.out.print("\nNumero de intentos: " + intentos + "\n");
                }
                if(intentos == 0){
                    System.out.print("\nError a excedido el numero de intentos, terminando acceso\n\n");
                    System.exit(0);
                }
            }while(intentos > 0);
        }else{
            System.out.printf("\nError ese usuario no existe");
            //System.exit(0);
        }

        /*do{
            System.out.printf("\n¿Cual es su saldo?: ");
            saldoInicial = sc.nextDouble();

            if(saldoInicial < 0){
                System.err.print("\nSu saldo debe ser positivo o 0\n\n");
            } else {
                opcion = 0;
            }
        }while(opcion == 1);*/

        //System.out.printf("\n\n------------------------------------%n");

        System.out.printf("\nBienvenido %s a %s, su saldo es: %.2f%n"
        , NOMBRES[pos], NOMBRE_BANCO, saldos[pos]);

        do{
            pos2 = -1;
            System.out.print(
                """

                Menu de opciones:
                1. Consultar saldo
                2. Depositar
                3. Retirar
                4. Transferencia
                5. Salir

                ¿Que opcion desea elegir?:  """
            );
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    System.out.printf("\n%s tu saldo es de: %.2f", nombreUsuario, saldos[pos]);
                    break;
                case 2:
                    System.out.printf("\nQue cantidad desea depositar?: ");
                    deposito = sc.nextDouble();
                    if(deposito < 0){
                        System.out.printf("\nError cantidad invalida");
                    } else{
                        saldos[pos] += deposito;
                        System.out.printf("\n%s tu nuevo saldo es: %.2f%n",nombreUsuario , saldos[pos]);
                    }
                    break;
                case 3:
                    System.out.printf("\nQue cantidad desea retirar?: ");
                    retiro = sc.nextDouble();
                    if(retiro < 0 ){
                        System.out.printf("\nError cantidad invalida");
                    } else {
                        if(saldos[pos] < retiro){
                            System.out.printf("\nLo sentimos %s, no tienes suficiente saldo para ese retiro, le sugerimos añadir más fondos\n", nombreUsuario);
                        }else{
                        saldos[pos] -= retiro;
                        System.out.printf("\n\nTu saldo es: %.2f%n", saldos[pos]);
                        }
                    }
                    break;
                case 4:
                    sc.nextLine(); 
                    System.out.printf("\nA que numero usuario desea transferir?: ");
                    //nombreUsuario = sc.nextLine();
                    pos1 = sc.nextInt();
                    if(pos1 > NOMBRES.length || pos1 < 0){
                        System.out.print("\nError, usuario no reconocido\n");
                        break;
                    }else{
                        for(int i = 0; i < NOMBRES.length; i++){
                            //if(nombreUsuario.equals(NOMBRES[i]) && !NOMBRES[i].equals(NOMBRES[pos])){
                            if(pos1 == i){
                                pos2 = i;
                                nombreUsuario = NOMBRES[pos2];
                            }
                        }
                    }
                    
                    if(pos2 != -1 && !nombreUsuario.equals(NOMBRES[pos])){
                        System.out.printf("\nQue cantidad desea transferir?: ");
                        transferencia = sc.nextDouble();
                        if(transferencia < 0 ){
                            System.out.printf("\nError cantidad invalida");
                        } else if(transferencia > saldos[pos]){
                            System.out.printf("\nError dinero insuficiente");
                        } else{
                            saldos[pos2] += transferencia;
                            saldos[pos] -= transferencia;
                            System.out.printf("\n\n%s tu nuevo saldo es de %.2f", NOMBRES[pos], saldos[pos]);
                            System.out.printf("\nA %s se le a depositado %.2f, su nuevo saldo es de %.2f\n", NOMBRES[pos2], transferencia, saldos[pos2]);

                        }
                    } else if(nombreUsuario.equals(NOMBRES[pos])){
                        System.out.printf("\nError no se puede auto transferir\n");
                    } else if( pos2 == -1){
                        System.out.printf("\nError ese usuario no existe\n");
                    }
                    break;
                case 5:
                    System.out.printf("\nGracias %s por usar %s vuelva pronto", nombreUsuario, NOMBRE_BANCO);
                    break;
                default:
                    System.out.printf("\n\nOpcion invalida");
            }

        }while(opcion != 5);

        sc.close();
    }
}

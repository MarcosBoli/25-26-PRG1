package entregas.BolivarMarcos.ejercicios;

public class ViajeMarco {

    public static void main(String[] args) {

        boolean Encontrados = false;
        final int DISTANCIA_INICIAL = 350;
        final int AVANCE_MADRE = 80;
        double distancia = DISTANCIA_INICIAL;
        int diaActual = 0;
        int velocidadMarcoInicial;
        int tiempo;
        double velocidadMarco = 0;
        double avanceMarco;
        final double PROBABILIDAD_AMEDIO_CANSADO = 0.25;
        final double REDUCCION_VELOCIDAD_AMEDIO_CANSADO=0.1;
        final double PROBABILIDAD_AMEDIO_HUYE = 0.15;
        final int PREDIDA_TIEMPO_AMEDIO_HUYE=2;
        final double PROBABILIDAD_LLUVIA_NORMAL = 0.4;
        final double REDUCCION_VELOCIDAD_LLUVIA_NORMAL = 0.25;
        final double REDUCCION_VELOCIDAD_LLUVIA_FUERTE = 0.75;
        final double PROBABILIDAD_LLUVIA_FUERTE = 0.1;
        boolean amedioSeEscapa = false;
        double clima;
        double comportamientoAmedio;

        System.out.println("EL DIARIO DE MARCO\n============================");
        while (!Encontrados) {

            diaActual++;
            System.out.println("DIA: " + diaActual);
            velocidadMarcoInicial = (int) (Math.random() * (15 - 10 + 1) + 10);
            clima = (Math.random());
            tiempo = (int) (Math.random() * (10 - 8 + 1) + 8);
            if (clima > PROBABILIDAD_LLUVIA_FUERTE) {
                velocidadMarco = velocidadMarcoInicial;
                System.out.println("Hoy ha hecho bueno");
            } else if (clima <= PROBABILIDAD_LLUVIA_NORMAL && clima > PROBABILIDAD_LLUVIA_FUERTE) {
                velocidadMarco = velocidadMarcoInicial * REDUCCION_VELOCIDAD_LLUVIA_NORMAL;
                System.out.println("Hoy ha habido una suave lluvia");
            } else if (clima <= PROBABILIDAD_LLUVIA_FUERTE) {
                velocidadMarco = velocidadMarcoInicial * REDUCCION_VELOCIDAD_LLUVIA_FUERTE;
                System.out.println("Hoy ha habido una lluvia torrencial");
            }

            comportamientoAmedio = (Math.random());
            if (comportamientoAmedio <= PROBABILIDAD_AMEDIO_HUYE) {
                amedioSeEscapa = true;
            }

            comportamientoAmedio = Math.random();

            if (comportamientoAmedio > PROBABILIDAD_AMEDIO_CANSADO && !amedioSeEscapa) {
                System.out.println("Amedio se ha comportado realmente bien hoy!");

            } else if (comportamientoAmedio <= PROBABILIDAD_AMEDIO_CANSADO && !amedioSeEscapa) {
                velocidadMarco=velocidadMarco-REDUCCION_VELOCIDAD_AMEDIO_CANSADO;
                System.out.println("Hoy Amedio se ha cansado y he tenido que llevarlo en brazos!");

            } else if (comportamientoAmedio > PROBABILIDAD_AMEDIO_CANSADO && amedioSeEscapa) {
                tiempo=tiempo-PREDIDA_TIEMPO_AMEDIO_HUYE;
                System.out.println("Hoy Amedio ha decidido escaparse y he tenido que perseguirle, perdiendo 2 horas...");

            } else if (comportamientoAmedio <= PROBABILIDAD_AMEDIO_CANSADO && amedioSeEscapa) {
                velocidadMarco=velocidadMarco-REDUCCION_VELOCIDAD_AMEDIO_CANSADO;
                tiempo=tiempo-PREDIDA_TIEMPO_AMEDIO_HUYE;
                System.out.println("Amedio hoy se ha escapado y encima se ha cansado despues...");
            }

            avanceMarco = velocidadMarco * tiempo;
            distancia = distancia - avanceMarco + AVANCE_MADRE;
            System.out.println("Marco ha caminado hoy a un ritmo de " + velocidadMarco
                    + "km/h \nEl tiempo que Marco ha estado caminando han sido " + tiempo + " horas");
            System.out.println("Su madre ha avanzado un total de 80km hoy.");
            if (distancia <= 0) {
                Encontrados = true;
                System.out.println("Marco se ha encontrado finalmente con su madre!!\n=====================================");
            }
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
        }

    }

}

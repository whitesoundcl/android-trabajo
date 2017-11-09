package com.example.whitesound.aprendiendoandroid;

import java.util.ArrayList;

/**
 *
 *
 * Clase con algunos metodos utiles.
 */

public class Utilidad {

    //Este método permite transformar un arraylist a un string.
    //Cada parametro almacenado en el string será separado por el valor que tenga "div"
    public static String convertirAString(ArrayList<String> arreglo, String div)
    {
        String retorno = "";
        for (int i = 0;i<arreglo.size();i++){
            //Si es el primer argumento que ingresa al string, no nos intereza que añada el div.
            if (retorno.length() == 0){
                retorno += arreglo.get(i);
            } else {
                retorno += div + arreglo.get(i);
            }
        }
        return retorno;

    }

    //Se convierte un string en arreglo, utilizando las separaciones "div"
    public static ArrayList<String> convertirAArrayList(String linea, String div){
        ArrayList<String> arreglo = new ArrayList<>();

        String[] dividido = linea.split(div);
        for (int i =0; i < dividido.length; i++)
        {
            arreglo.add(dividido[i]);
        }

        return arreglo;

    }

    /*
        Calendario chino:
     */

    //Este método busca un animal según el año
    public static String getAnimalPorAnnio(String annio){
        int numero = Integer.parseInt(annio);
        int i;
        System.out.println("año recibido: " + annio);
        for (i = 0;i < 12; i++){
            for (int j = 0 ; j < 675 ; j++)
            {
                if ((1900 + i) +( 12 * j) == numero)
                    return animalPorIndice(i+1);
            }
        }


        return "ERROR: ¿Año incorrecto?";
    }

    //Obtiene el año siguiente al que le toca su animal. (posterior a 2017).
    public static String getSiguienteAnnio(String annio)
    {
        int numero = Integer.parseInt(annio);
        int i;
        System.out.println("año recibido: " + annio);
        for (i = 0;i < 12; i++){
            for (int j = 0 ; j < 677 ; j++)
            {
                if ((1900 + i) +( 12 * j) == numero){
                    while(true)
                    {
                        int resultado = (1900 + i) +( 12 * j);
                        if (resultado > 2017 && resultado > numero){
                            return resultado + "";
                        } else {
                            j++;
                        }

                    }
                }

            }
        }
        return "ERROR: Error al intentar conseguir el siguiente año.";
    }

    public static String getFuturo(String animal)
    {
        switch (animal)
        {
            case "rata":
                return "Quienes han nacido en un año Rata, se verán beneficiados con la llegada del " +
                        "Gallo, los negocios y el trabajo serán muy ventajosos. Se trata de una etapa" +
                        " de fertilidad ideal para comenzar nuevos proyectos o bien renovar la vida " +
                        "laboral. La Rata es rápida y con su inteligencia sabrá aprovechar las oportunidades" +
                        " que el año Gallo le brinda. Pero deberán ser disciplinados y seguir las reglas. " +
                        "Trabajadores y resolutivos, comenzarán un año muy intenso y ajetreado, pero tienen " +
                        "recursos y cualidades para afrontarlo con éxito. Para el amor, será un período exquisito, " +
                        "dejarán de lado el pasado, sanarán viejas heridas y estarán predispuestos a construir" +
                        " relaciones sanas y sinceras.";
            case "bufalo":
                return "El Buey se verá beneficiado este año por la energía afín del Gallo. Ambos son" +
                        " pragmáticos y prefieren no tomar ningún riesgo. Las personas nacidas un año " +
                        "Buey poseen metas claras, se esfuerzan por alcanzarlas y disfrutan de sus logros. " +
                        "Este año se liberarán de viejas ataduras y emprenderán un camino de superación, tanto " +
                        "en lo personal como en el ámbito laboral y material. Será un año muy productivo pero" +
                        " deberán ser más flexibles, de eso modo podrán abrirse a nuevos horizontes y explorar " +
                        "otros mundos. Las uniones estables y los romances que se inicien estarán " +
                        "favorecidos pero deberán evitar perder la paciencia o situarse en lugares rígidos" +
                        " de exigencia hacia el otro.";
            case "tigre":
                return "Para quienes nacieron bajo la influencia del Tigre, será un mejor año que el" +
                        " anterior, Mono. Sin embargo, no deberán asumir grandes riesgos, sino más bien " +
                        "trabajar y conservar lo que hasta ahora han conseguido. Excelente año para m" +
                        "anifestar el costado más artístico y creativo del signo. Dedicar tiempo a ex" +
                        "plorar nuevas alternativas de expresión será sanador y ayudará a compensar " +
                        "las extensas horas de trabajo que les espera. En el amor comenzará complica" +
                        "do pero mejorará a medida que el año avance. Cuidado con la tendencia a pen" +
                        "sar siempre en el futuro y que eso impida trabajar el presente para que las" +
                        " cosas ocurran. Excelentes novedades en torno al hogar y la familia.";
            case "liebre":
                return "Este año surgirán nuevas oportunidades pero deberán estar atentos al tomar d" +
                        "ecisiones ya que la energía del Gallo, signo opuesto y complementario del G" +
                        "ato, exigirá compromiso, enfoque y determinación. La intuición que tienen p" +
                        "ara captar el fondo de las situaciones, les ayudará enormemente este año y " +
                        "sabrán salir siempre de la mejor manera, caer siempre parados. Aprenderán m" +
                        "ucho a través de las asociaciones y alianzas que establezcan, reconocerán su" +
                        "s verdaderos propósitos y necesidades y sabrán poner límites cuando sea nece" +
                        "sario. Se definen situaciones en la pareja, que podrá afianzarse o terminar " +
                        "para siempre. Pasarán momentos de soledad, lo cual no será para nada malo, ya" +
                        " que hay una gran oportunidad de encontrar el amor verdadero este año.";
            case "dragon":
                return "Buen tiempo para aprender, estudiar, publicitar o promocionarse. El peligro " +
                        "estará en querer hacer muchas cosas al mismo tiempo y disgregarse. Deberán " +
                        "focalizar los esfuerzos y no dudar a la hora de tomar decisiones radicales. " +
                        "Habrá mucha actividad pero poco tiempo para disfrutar en casa, lo cual puede" +
                        " hacerles perder el buen humor. Será imprescindible disponer de una magnífic" +
                        "a organización, planificar muy bien el tiempo y combinar el trabajo con las" +
                        " necesidades más espirituales. Necesitarán cultivar la paciencia y evitar c" +
                        "ualquier situación conflictiva en las relacione. Es momento de hacer una ev" +
                        "aluación y decidir ir más despacio.";
            case "serpiente":
                return "2017 será un año de grandes logros para la Serpiente. Aparecerán oportunidad" +
                        "es, estarán motivados y tendrán buen juicio para poner en marcha planes bie" +
                        "n concretos. La habilidad y majestuosidad que despliega el Gallo de fuego, " +
                        "la Serpiente la capitalizará en el manejo de las relaciones públicas, se ab" +
                        "rirán nuevas puertas. Las artistas del signo obtendrán grandes logros y gan" +
                        "ancias a través de sus obras. Será necesario ser constante para alcanzar lo" +
                        "s objetivos que realmente importan. Será un año de enamoramiento y conquista" +
                        ", donde disfrutarán a pleno de la sensualidad y el misterio que los caracter" +
                        "iza. En la pareja habrá buena convivencia si evitan los excesos y los celos.";
            case "caballo":
                return "El año del Gallo se presenta desafiante para el Caballo que tendrá que deten" +
                        "er su paso, poner orden y evitar la comodidad. No será un año del todo fáci" +
                        "l y las contradicciones estarán a la orden del día. Pero tendrán la oportu" +
                        "nidad de ser más conscientes de las propias debilidades y contar con las he" +
                        "rramientas para transformarlas. Si lo logran, alcanzarán gran prosperidad " +
                        "en cada ámbito de vida. Suavizar el carácter, enfocar y canalizar positivam" +
                        "ente las energías será preciso para lograr bienestar y armonía en las relac" +
                        "iones. Para la vida en pareja es un año de pruebas en donde el diálogo será " +
                        "la clave para encontrar un punto de equilibrio en la relación.";
            case "cabra":


                return "Se sentirán optimistas y lograrán una posición estable y segura. Deberán esf" +
                        "orzarse pero alcanzarán grandes metas ya que contarán con una importante cl" +
                        "aridad mental para actuar en el momento oportuno. Habrá novedades en asuntos" +
                        " inmobiliarios y todo lo relacionado con la vivienda. Reparaciones o renova" +
                        "ciones dentro del hogar, podrán contar con mayor comodidad y confort. Un ca" +
                        "mbio importante en la forma de comunicarse les permitirá establecer vínculo" +
                        "s más profundos. Podrán viajar, mudarse y recibir la llegada de un gran amo" +
                        "r. En la pareja, deberán esforzarse por escuchar al otro, comprender sus ne" +
                        "cesidades y no querer imponer siempre sus puntos de vista.";
            case "mono":
                return "Para quienes han nacido en un año Mono, será una etapa de concreciones, idea" +
                        "l para desarrollar y concluir proyectos iniciados el año anterior. Durante 2" +
                        "016, el año del Mono, han comenzado una nueva etapa, un nuevo ciclo de 12 añ" +
                        "os. El Gallo les pedirá ahora concreciones materiales, responsabilidad y emp" +
                        "eño. Los cambios se darán en la manera de administrar las energías y el tiem" +
                        "po, adaptarse a ciertas rutinas será la clave. En el amor, la tendencia será" +
                        " a establecer un compromiso estable y renovarán los votos en la pareja. Si es" +
                        "tás sola, podrán iniciar un romance intenso con alguien en quien encuentren " +
                        "comprensión, tranquilidad y confianza.";
            case "gallo":
                return "La energía del fuego será la encargada de dar vida a un año intenso y lleno " +
                        "de positivismo para todos los Gallo. Con una actitud más práctica y decidida" +
                        ", sentirán que nada está fuera de su alcance. Sabrán administrar su intensa" +
                        " energía con más inteligencia y tendrán la posibilidad de conocer gente infl" +
                        "uyente que los beneficiará en su profesión. Crecerán las responsabilidades," +
                        " pero hasta las cosas más complicadas serán fáciles de realizar. El desafí" +
                        "o estará en saber aceptar los buenos consejos de gente más experimentada y a" +
                        "prender a delegar cuando las situaciones los desborden. Brillarán con enca" +
                        "nto despertando grandes pasiones. Las parejas se encenderán, pudiendo reavi" +
                        "var la relación o bien poniéndola en crisis, dependerá de cómo equilibren " +
                        "sus emociones. Los Gallos solitarios tendrán grandes oportunidades de nuev" +
                        "as conquistas.";
            case "perro":
                return "Al comenzar el año deberán ir sin apresuramientos. No será conveniente reali" +
                        "zar cambios profundos ni definitivos, sino más bien esperar para tomar gran" +
                        "des decisiones. En 2017 la independencia será su foco pero deberán tener es" +
                        "pecial cuidado con los conflictos a nivel laboral, con perder la paciencia." +
                        " Trabajarán para labrarse un buen futuro profesional, del cual recogerá los" +
                        " frutos en 2018, que será el año del Perro. Será un año excitante y no todo " +
                        "serán dificultades: obtendrán algunos triunfos importantes. Este año Gallo, " +
                        "deberán ser más firmes en sus puntos de vista y no dejarse llevar con facil" +
                        "idad por las opiniones ajenas. Aceptación y mayor independencia serán la cl" +
                        "ave para vivir en armonía el amor y la vida en pareja.";
            case "jabali":

                return "Será un buen año para el Jabalí, el Gallo lo sabrá guiar por el camino de su" +
                        " propia evolución. Su energía de fuego los invitará a tomar el control de s" +
                        "us vidas y a actuar con energía y decisión. El trabajo en equipo, la vida s" +
                        "ocial y los amigos ocuparán un lugar preponderante. Este año se movilizan v" +
                        "iejos sueños, se aclaran las ideas y muchos serán los que encuentren el ver" +
                        "dadero amor. El autoconocimiento y la búsqueda interior serán la clave para" +
                        " desprenderse de todo aquello que impide el avance. Más libres y consciente" +
                        "s, tendrán la posibilidad de ver florecer su vida de relación. Vivirán el am" +
                        "or a pleno con momentos de gran sensualidad, romanticismo y mucho placer.";
            default:
                return "";
        }
    }

    //metodo auxiliar de getAnimalPorAnnio()
    private static String animalPorIndice(int i)
    {
        System.out.println("animalPorIndice(int: "+ i + ")");
        switch (i){
            case 1:
                return "rata";
            case 2:
                return "bufalo";
            case 3:
                return "tigre";
            case 4:
                return "liebre";
            case 5:
                return "dragon";
            case 6:
                return "serpiente";
            case 7:
                return "caballo";
            case 8:
                return "cabra";
            case 9:
                return "mono";
            case 10:
                return "gallo";
            case 11:
                return "perro";
            case 12:
                return "jabali";
            default:
                    return "ERROR: ¿Indice de animal incorrecto?";
        }
    }

    //Retorna el id de la imagen según el nombre del animal.
    public static int getImagenPorNombre(String nombre)
    {
        switch (nombre)
        {
            case "rata":
                return R.drawable.rata;
            case "bufalo":
                return R.drawable.bufalo;
            case "tigre":
                return R.drawable.tigre;
            case "liebre":
                return R.drawable.liebre;
            case "dragon":
                return R.drawable.dragon;
            case "serpiente":
                return R.drawable.serpiente;
            case "caballo":
                return R.drawable.caballo;
            case "cabra":
                return R.drawable.cabra;
            case "mono":
                return R.drawable.mono;
            case "gallo":
                return R.drawable.gallo;
            case "perro":
                return R.drawable.perro;
            case "jabali":
                return R.drawable.chancho;
            default:
                return 9999;
        }
    }

    //Solo para efectos de prueba:
    //Imprime el contenido de un arreglo con indicando de donde proviene.
    public static void mostrarArreglo(ArrayList<String> arreglo, String verbose)
    {
        System.out.println("-------------------mostrando arreglo: \n"+ verbose);
        for (int i = 0;i<arreglo.size();i++)
        {
            System.out.println(arreglo.get(i));
        }
        System.out.println("-----------------FIN----------------");
    }





}

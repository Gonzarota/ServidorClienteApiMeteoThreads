import com.server.Checker;
import com.server.domain.elementsInfo.Coordenadas;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CheckerTest {


    @Test
    public void checkFormat_isok_test(){
        //1.Inicialización del entorno

        String coordenadas="51.10,46.78";

        //2.Ejecución del código

        Boolean consulta= Checker.checkFormato(coordenadas);

        //3.Comprobación de los resultados

        Assertions.assertEquals(true,consulta);
    }

    @Test
    public void checkFormat_nook_test(){
        //1.Inicialización del entorno

        String coordenadas="51.a,46.78";

        //2.Ejecución del código

        Boolean consulta= Checker.checkFormato(coordenadas);

        //3.Comprobación de los resultados

        Assertions.assertEquals(false,consulta);
    }

    @Test
    public void checkRange_isok_test(){
        //1.Inicialización del entorno

        Coordenadas test=new Coordenadas(-179f,76f);

        //2.Ejecución del código

        Boolean consulta= Checker.checkRange(test);

        //3.Comprobación de los resultados

        Assertions.assertEquals(true,consulta);
    }

    @Test
    public void checkRange_nook_test(){
        //1.Inicialización del entorno

        Coordenadas test=new Coordenadas(-179f,91f);

        //2.Ejecución del código

        Boolean consulta= Checker.checkRange(test);

        //3.Comprobación de los resultados

        Assertions.assertEquals(false,consulta);
    }
}

import com.server.domain.elementsInfo.Coordenadas;
import com.server.utils.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UtilsTest {

    @Test
    public void parseCoordenadas_isok_test(){
        //1.Inicialización del entorno

        Coordenadas expectedResult=new Coordenadas(51.10f,46.78f);

        String coor="{lon:51.10,lat:46.78}";

        //2.Ejecución del código

        Coordenadas result= Utils.parseCoordenadas(coor);

        //3.Comprobación de los resultados
        Assertions.assertEquals(expectedResult, result);

        Assertions.assertEquals(expectedResult.getLat(),result.getLat());
        Assertions.assertEquals(expectedResult.getLon(),result.getLon());
    }
}

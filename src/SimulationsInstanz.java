import java.util.ArrayList;
import java.util.List;

public class SimulationsInstanz{
        public SimulationsInstanz() {
                jahresberichtList = new ArrayList<>();
        }

        List<Jahresbericht> jahresberichtList;

        public List<Jahresbericht> getJahresberichtList() {
                return jahresberichtList;
        }

        public void setJahresberichtList(List<Jahresbericht> jahresberichtList) {
                this.jahresberichtList = jahresberichtList;
        }
}

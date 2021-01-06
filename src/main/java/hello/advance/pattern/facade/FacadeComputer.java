package hello.advance.pattern.facade;

/**
 * @author karl xie
 */
public class FacadeComputer {

    private Cpu cpu;
    private Ram ram;
    private Ssd ssd;

    public FacadeComputer() {
        this.cpu = new Cpu();
        this.ram = new Ram();
        this.ssd = new Ssd();
    }

    /** Cpu On **/
    public void onCpu() {
        this.cpu.open();
    }

    /** Ram On **/
    public void onRam() {
        this.ram.open();
    }

    /** Ssd On **/
    public void onSsd() {
        this.ssd.open();
    }

    /** All On **/
    public void allOn() {
        this.cpu.open();
        this.ram.open();
        this.ssd.open();
    }
}
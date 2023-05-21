package codeGenerator;

import codeGenerator.Abstractions.IMemory;
import codeGenerator.Enums.Operation;

import java.util.ArrayList;

/**
 * Created by mohammad hosein on 6/27/2015.
 */
public class Memory implements IMemory {
    private ArrayList<_3AddressCode> codeBlock;
    private int lastTempIndex;
    private int lastDataAddress;
    private final int stratTempMemoryAddress = 500;
    private final int stratDataMemoryAddress = 200;
    private final int dataSize = 4;
    private final int tempSize = 4;

    public Memory() {
        codeBlock = new ArrayList<_3AddressCode>();
        lastTempIndex = stratTempMemoryAddress;
        lastDataAddress = stratDataMemoryAddress;
    }

    @Override
    public void updateLastTempIndex(){
        lastTempIndex += tempSize;
    }

    @Override
    public int getTemp() {
        lastTempIndex += tempSize;
        return lastTempIndex - tempSize;
    }

    @Override
    public int getDateAddress() {
        lastDataAddress += dataSize;
        return DateAddress();
    }

    private int DateAddress(){
        return lastDataAddress - dataSize;
    }

    @Override
    public int saveMemory() {
        getCodeBlock().add(new _3AddressCode());
        return getCodeBlock().size() - 1;
    }

    @Override
    public void add3AddressCode(Operation op, Address opr1, Address opr2, Address opr3) {
        getCodeBlock().add(new _3AddressCode(op, opr1, opr2, opr3));
    }

    @Override
    public void add3AddressCode(int i, Operation op, Address opr1, Address opr2, Address opr3) {
        getCodeBlock().remove(i);
        getCodeBlock().add(i, new _3AddressCode(op, opr1, opr2, opr3));
    }

    @Override
    public int getCurrentCodeBlockAddress() {
        return getCodeBlock().size();
    }

    @Override
    public void pintCodeBlock() {
        System.out.println("Code Block");
        for (int i = 0; i < getCodeBlock().size(); i++) {
            System.out.println(i + " : " + getCodeBlock().get(i).toString());
        }
    }

    ArrayList<_3AddressCode> getCodeBlock(){
        return codeBlock;
    }

}

class _3AddressCode {
    public Operation operation;
    public Address Operand1;
    public Address Operand2;
    public Address Operand3;

    public _3AddressCode() {

    }

    public _3AddressCode(Operation op, Address opr1, Address opr2, Address opr3) {
        operation = op;
        Operand1 = opr1;
        Operand2 = opr2;
        Operand3 = opr3;
    }

    public String toString() {
        if (operation == null) return "";
        StringBuffer res = new StringBuffer("(");
        res.append(operation.toString()).append(",");
        if (Operand1 != null) res.append(Operand1.toString());
        res.append(",");
        if (Operand2 != null) res.append(Operand2.toString());
        res.append(",");
        if (Operand3 != null) res.append(Operand3.toString());
        res.append(")");

        return res.toString();
    }
}

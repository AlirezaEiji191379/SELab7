package codeGenerator.Abstractions;

import codeGenerator.Address;
import codeGenerator.Enums.Operation;

public interface IMemory {
    int getTemp();

    int getDateAddress();

    int saveMemory();

    void add3AddressCode(Operation op, Address opr1, Address opr2, Address opr3);

    void add3AddressCode(int i, Operation op, Address opr1, Address opr2, Address opr3);

    int getCurrentCodeBlockAddress();

    void pintCodeBlock();
}

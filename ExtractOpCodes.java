// Extract opcodes from binary
//@category Analysis

import ghidra.app.script.GhidraScript;
import ghidra.program.model.listing.Listing;
import ghidra.program.model.listing.CodeUnit;
import ghidra.program.model.listing.Instruction;
import java.io.FileWriter;
import java.io.File;

public class ExtractOpCodes extends GhidraScript {

    @Override
    public void run() throws Exception {
        println("Starting OpCode extraction...");
        Listing listing = currentProgram.getListing();
        String outputPath = getScriptArgs()[0];
        File outputFile = new File(outputPath);
        outputFile.getParentFile().mkdirs();
        
        try (FileWriter writer = new FileWriter(outputFile)) {
            writer.write("# File: " + currentProgram.getName() + "\n");
            writer.write("# Timestamp: " + new java.util.Date() + "\n\n");
            
            println("Processing instructions...");
            int count = 0;
            for (CodeUnit codeUnit : listing.getCodeUnits(true)) {
                if (codeUnit instanceof Instruction) {
                    Instruction instruction = (Instruction) codeUnit;
                    String mnemonic = instruction.getMnemonicString();
                    if (mnemonic != null && !mnemonic.isEmpty()) {
                        writer.write(mnemonic);
                        String operands = instruction.toString();
                        if (operands.contains(" ")) {
                            operands = operands.substring(operands.indexOf(' ') + 1);
                            writer.write(" " + operands);
                        }
                        writer.write("\n");
                        count++;
                        if (count % 1000 == 0) {
                            println("Processed " + count + " instructions...");
                        }
                    }
                }
            }
            println("Completed OpCode extraction to: " + outputPath);
            println("Total instructions processed: " + count);
        } catch (Exception e) {
            println("Error writing to output file: " + e.getMessage());
        }
    }
}

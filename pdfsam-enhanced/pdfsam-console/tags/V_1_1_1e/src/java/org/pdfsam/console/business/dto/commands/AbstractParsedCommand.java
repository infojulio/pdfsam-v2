/*
 * Created on 1-Oct-2007
 * Copyright (C) 2006 by Andrea Vacondio.
 *
 * This program is free software; you can redistribute it and/or modify it under the terms of the 
 * GNU General Public License as published by the Free Software Foundation; 
 * either version 2 of the License.
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. 
 * See the GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License along with this program; 
 * if not, write to the Free Software Foundation, Inc., 
 *  59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 */
package org.pdfsam.console.business.dto.commands;

import java.io.File;
import java.io.Serializable;

import com.lowagie.text.pdf.PdfWriter;
/**
 * Abstract parsed command dto filled by parsing service and used by worker service
 * @author Andrea Vacondio
 *
 */
public abstract class AbstractParsedCommand implements Serializable {

    public static final String COMMAND_CONCAT = "concat";
    public static final String COMMAND_SPLIT = "split";    
    public static final String COMMAND_ECRYPT = "encrypt";  
    public static final String COMMAND_MIX = "mix"; 
    
    public static final char VERSION_1_2 = PdfWriter.VERSION_1_2;
    public static final char VERSION_1_3 = PdfWriter.VERSION_1_3;
    public static final char VERSION_1_4 = PdfWriter.VERSION_1_4;
    public static final char VERSION_1_5 = PdfWriter.VERSION_1_5;
    public static final char VERSION_1_6 = PdfWriter.VERSION_1_6;    
    public static final char VERSION_1_7 = PdfWriter.VERSION_1_7;
    
	public static final String PDFVERSION_ARG = "pdfversion";
	public static final String OVERWRITE_ARG = "overwrite";
	public static final String COMPRESSED_ARG = "compressed";
	public static final String LOG_ARG = "log";
	
	/**
	 * <code>true</code> if output file overwrite is enabled
	 */
	private boolean overwrite = false;
	/**
	 * <code>true</code> if output file must be compressed
	 */
	private boolean compress = false; 
	/**
	 * log file
	 */
	private File logFile = null;
	/**
	 * Version of the output document/documents
	 */
	private Character outputPdfVersion = null;
	
	
	public AbstractParsedCommand(){		
	};
	
	public AbstractParsedCommand(boolean overwrite, boolean compress,File logFile, char outputPdfVersion) {
		this.overwrite = overwrite;
		this.compress = compress;
		this.logFile = logFile;
		this.outputPdfVersion = new Character(outputPdfVersion);
	}

	/**
	 * @return the overwrite
	 */
	public boolean isOverwrite() {
		return overwrite;
	}

	/**
	 * @param overwrite the overwrite to set
	 */
	public void setOverwrite(boolean overwrite) {
		this.overwrite = overwrite;
	}

	/**
	 * @return the compress
	 */
	public boolean isCompress() {
		return compress;
	}

	/**
	 * @param compress the compress to set
	 */
	public void setCompress(boolean compress) {
		this.compress = compress;
	}

	/**
	 * @return the logFile
	 */
	public File getLogFile() {
		return logFile;
	}

	/**
	 * @param logFile the logFile to set
	 */
	public void setLogFile(File logFile) {
		this.logFile = logFile;
	}
	
	/**
	 * @return the outputPdfVersion
	 */
	public Character getOutputPdfVersion() {
		return outputPdfVersion;
	}

	/**
	 * @param outputPdfVersion the outputPdfVersion to set
	 */
	public void setOutputPdfVersion(char outputPdfVersion) {
		this.outputPdfVersion = new Character(outputPdfVersion);
	}

	/**
	 * @param outputPdfVersion the outputPdfVersion to set
	 */
	public void setOutputPdfVersion(Character outputPdfVersion) {
		this.outputPdfVersion = outputPdfVersion;
	}

	/**
	 * @return The command associated with this dto
	 */
	public abstract String getCommand();

	public String toString(){
		StringBuffer retVal = new StringBuffer();
		retVal.append("[overwrite="+overwrite+"]");
		retVal.append("[compress="+compress+"]");
		retVal.append("[outputPdfVersion="+outputPdfVersion+"]");
		retVal.append((logFile== null)?"":"[log="+logFile.getAbsolutePath()+"]");
		return retVal.toString();
	}
}

/**
 * 
 */
package com.barun.pdfutil.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.pdmodel.graphics.PDXObject;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

/**
 * @author anushka
 *
 */
public class PDFUtils {

	/**
	 * 
	 * @param filename
	 * @return
	 * @throws IOException
	 */
	public static boolean isPdfNative(String filename) throws IOException {
		int totalNoOfScannedPages = 0;
		PDDocument doc = PDDocument.load(new File(filename));
		int totalNoOfPages = doc.getNumberOfPages();
		System.out.println(doc.getDocument());
		System.out.println(doc.getDocumentCatalog());
		System.out.println(doc.getDocumentInformation());
		for (PDPage page : doc.getPages()) {
			PDResources resource = page.getResources();
			for (COSName xObjectName : resource.getXObjectNames()) {
				PDXObject xObject = resource.getXObject(xObjectName);
				if (xObject instanceof PDImageXObject) {
					((PDImageXObject) xObject).getImage();
					totalNoOfScannedPages++;
				}
			}
		}
		doc.close();
		if (totalNoOfScannedPages == totalNoOfPages) // PDF has scanned Document
		{
			return false;
		} else {
			return true;
		}

	}
	
	public static void mergePdf(List<String> pdfs) throws InvalidPasswordException, IOException {
		//Loading an existing PDF document
	      File file1 = new File("/Users/anushka/Documents/workspace-sts-3.9.2.RELEASE/pdfutil/231217, 1204 PM Office Lens.pdf");
	      PDDocument doc1 = PDDocument.load(file1);
	       
	      File file2 = new File("/Users/anushka/Documents/workspace-sts-3.9.2.RELEASE/pdfutil/British Council IELTS Online Application.pdf");
	      PDDocument doc2 = PDDocument.load(file2);
	         
	      //Instantiating PDFMergerUtility class
	      PDFMergerUtility PDFmerger = new PDFMergerUtility();

	      //Setting the destination file
	      PDFmerger.setDestinationFileName("/Users/anushka/Documents/workspace-sts-3.9.2.RELEASE/pdfutil/merged.pdf");

	      //adding the source files
	      PDFmerger.addSource(file1);
	      PDFmerger.addSource(file2);

	      //Merging the two documents
	      PDFmerger.mergeDocuments();

	      System.out.println("Documents merged");
	      //Closing the documents
	      doc1.close();
	      doc2.close();
	}
	
}

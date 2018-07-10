/**
 * 
 */
package pdfutil;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.barun.pdfutil.utils.PDFUtils;

/**
 * @author anushka
 *
 */
public class PDFMetaDataUtilsTest {

	@Test
	public void testPdfIsScanned() throws IOException {
		assertEquals(false,PDFUtils.isPdfNative("/Users/anushka/Documents/workspace-sts-3.9.2.RELEASE/pdfutil/231217, 1204 PM Office Lens.pdf"));
	}
	
	@Test
	public void testPdfIsNative() throws IOException {
		assertEquals(true,PDFUtils.isPdfNative("/Users/anushka/Documents/workspace-sts-3.9.2.RELEASE/pdfutil/British Council IELTS Online Application.pdf"));
	}
	@Test
	public void testPdfIsNativeOrScanned() throws IOException {
		assertEquals(true,PDFUtils.isPdfNative("/Users/anushka/Documents/workspace-sts-3.9.2.RELEASE/pdfutil/merged.pdf"));
	}
	@Test
	public void testmergePdf() throws IOException {
		PDFUtils.mergePdf(null);
	}
	
}

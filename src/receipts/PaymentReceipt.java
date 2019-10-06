package receipts;

import java.io.InputStream;
import java.util.ArrayList;
import org.jboss.logging.Logger;

import dto.PaymentDTO;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class PaymentReceipt {
	
	private JasperReport 	_receipt;
	private JasperViewer 	_receiptViewer;
	private JasperPrint		_receiptFull;
	private Logger log = Logger.getLogger(ReservationReceipt.class);
	
	public PaymentReceipt(PaymentDTO payment)
    {
    	ArrayList<PaymentDTO> paymentInList = new ArrayList<PaymentDTO>();
    	paymentInList.add(payment);
			
    	try		{
//    		InputStream jasperStream2 = getClass().getResourceAsStream("/PaymentSubReceipt.jasper");
//			JasperReport subReceipt =  (JasperReport) JRLoader.loadObject(jasperStream2);
//			JasperFillManager.fillReport(subReceipt, null, 
//					new JRBeanCollectionDataSource(payment.get_turns()));
    			
    		InputStream jasperStream = getClass().getResourceAsStream("/PaymentReceipt.jasper");
			_receipt =  (JasperReport) JRLoader.loadObject(jasperStream);
			_receiptFull = JasperFillManager.fillReport(this._receipt, null, 
					new JRBeanCollectionDataSource(paymentInList));
			
			log.info("Se cargó correctamente el reporte");
		}
		catch( JRException ex ) 
		{
			log.error("Ocurrió un error mientras se cargaba el archivo ReporteAgenda.Jasper", ex);
		}
    }       
    
    public void show()
	{
		_receiptViewer = new JasperViewer(_receiptFull,false);
		_receiptViewer.setVisible(true);
	}

}

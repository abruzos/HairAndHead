package receipts;

import java.io.InputStream;
import java.util.ArrayList;
import org.jboss.logging.Logger;

import dto.TurnDTO;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class ReservationReceipt 
{
	
	private JasperReport 	_receipt;
	private JasperViewer 	_receiptViewer;
	private JasperPrint		_receiptFull;
	private Logger log = Logger.getLogger(ReservationReceipt.class);
	
	public ReservationReceipt(TurnDTO turn)
    {
    	ArrayList<TurnDTO> turnInList = new ArrayList<TurnDTO>();
    	turnInList.add(turn);
			
    	try		{
    		InputStream jasperStream = getClass().getResourceAsStream("/ReservationReceipt.jasper");
			_receipt =  (JasperReport) JRLoader.loadObject(jasperStream);
			_receiptFull = JasperFillManager.fillReport(this._receipt, null, 
					new JRBeanCollectionDataSource(turnInList));
			log.info("Se cargó correctamente el reporte");
		}
		catch( JRException ex ) 
		{
			log.error("Ocurrió un error mientras se cargaba el archivo ReporteAgenda.Jasper", ex);
		}
    }       
    
    public void mostrar()
	{
		_receiptViewer = new JasperViewer(_receiptFull,false);
		_receiptViewer.setVisible(true);
	}

}

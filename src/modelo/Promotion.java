package modelo;

import java.util.List;
import dto.PromotionDTO;
import persistencia.dao.implementacion.PromotionJPA;
import persistencia.dao.interfaz.PromotionDAO;

public class Promotion 
{
	private PromotionDAO _promotion;
	
	public PromotionDAO createPromotionDAO() 
	{
		return new PromotionJPA();
	}
	
	//Lista de todas promociones (DENTRO DEL SISTEMA)
		public List<PromotionDTO> obtainPromotion() throws Exception 
		{
			return _promotion.all();
		}
	
}
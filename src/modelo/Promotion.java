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
	
	public void createPromotion(PromotionDTO newPromotion) throws Exception 
	{
		_promotion.create(newPromotion);
	}
	
	public void deletePromotion(PromotionDTO deletePromotion) throws Exception 
	{
		_promotion.delete(deletePromotion);
	}
	
	//Modificacion de un pago.
	public void updatePromotion(PromotionDTO updatePromotion) throws Exception 
	{
		_promotion.update(updatePromotion);
	}
	
	//Retorno de un pago por ID
		public void getPromotionID(long PromotionID) throws Exception 
		{
			_promotion.byId(PromotionID);
		}
	
	//Lista de todas promociones (DENTRO DEL SISTEMA)
		public List<PromotionDTO> obtainPromotion() throws Exception 
		{
			return _promotion.all();
		}
	
	
}
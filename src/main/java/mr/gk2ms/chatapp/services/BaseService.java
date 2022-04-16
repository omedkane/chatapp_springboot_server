package mr.gk2ms.chatapp.services;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

/**
 * @implNote Don't forget to override toModel and toEntity methods, by default
 *           they copy everything !
 */
public abstract class BaseService<Entity, Model> {
	private Class<Model> modelClass;
	private Class<Entity> entityClass;

	public Model toModel(Entity entity) throws InstantiationException, IllegalAccessException, IllegalArgumentException,
		InvocationTargetException, NoSuchMethodException, SecurityException {
		Model model = modelClass.getDeclaredConstructor().newInstance();

		BeanUtils.copyProperties(entity, model);

		return model;
	}

	public Entity toEntity(Model model) throws InstantiationException, IllegalAccessException, IllegalArgumentException,
		InvocationTargetException, NoSuchMethodException, SecurityException {
		Entity entity = entityClass.getDeclaredConstructor().newInstance();

		BeanUtils.copyProperties(model, entity);
		return entity;
	}

	public List<Model> toModelList(List<Entity> entities) {
		List<Model> models = new ArrayList<>();

		entities.forEach(entity -> {
			try {
				models.add(toModel(entity));
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
			}
		});

		return models;
	}
}

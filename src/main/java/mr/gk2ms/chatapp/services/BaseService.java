package mr.gk2ms.chatapp.services;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.BeanUtils;

/**
 * @implNote Don't forget to override toModel and toEntity methods, by default
 *           they copy everything !
 */
public abstract class BaseService<Entity, Model> {
	private Class<Model> modelClass;
	private Class<Entity> entityClass;

	public Model toModel(Entity entity) {
		try {
			Model model = modelClass.getDeclaredConstructor().newInstance();
			BeanUtils.copyProperties(entity, model);

			return model;
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
			| NoSuchMethodException | SecurityException error) {
			error.printStackTrace();
			return null;
		}

	}

	public List<Model> toModelAll(Collection<Entity> entities) {
		List<Model> models = new ArrayList<Model>();

		entities.forEach(entity -> {
			models.add(toModel(entity));

		});

		return models;
	}

	public Entity toEntity(Model model) {
		try {
			Entity entity = entityClass.getDeclaredConstructor().newInstance();
			BeanUtils.copyProperties(model, entity);
			return entity;

		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
			| NoSuchMethodException | SecurityException error) {
			error.printStackTrace();
			return null;
		}
	}

	public List<Entity> toEntityAll(List<Model> models) {
		List<Entity> entities = new ArrayList<Entity>();

		models.forEach(model -> {
			entities.add(toEntity(model));

		});

		return entities;
	}
}

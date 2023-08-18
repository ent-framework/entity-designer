package org.entframework.javafx.designer.emf;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Consumer;

/**
 * Form 的属性监听器
 * @param <T>
 */
public class AttributeFeatureAdapter<T> extends EContentAdapter {
    private final Logger LOGGER = LoggerFactory.getLogger(AttributeFeatureAdapter.class);
    private final EAttribute attribute;
    private final Consumer<T> subscriber;

    public AttributeFeatureAdapter(EAttribute attribute, Consumer<T> subscriber) {
        this.attribute = attribute;
        this.subscriber = subscriber;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void notifyChanged(Notification notification) {
        super.notifyChanged(notification);
        if (notification.getEventType() != Notification.REMOVING_ADAPTER) {
            if (notification.getFeature().equals(attribute)) {
                LOGGER.info(attribute.getName() + " CHANGED to " + notification.getNewValue());
                this.subscriber.accept((T)notification.getNewValue());
            }
        }
    }
}

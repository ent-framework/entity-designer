package org.entframework.javafx.designer.emf;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class MultiAttributeFeatureAdapter extends EContentAdapter {
    private final Logger LOGGER = LoggerFactory.getLogger(MultiAttributeFeatureAdapter.class);
    private final List<Object> features = new ArrayList<>();
    private final BiFunction<EObject, Object, Void> subscriber;

    public MultiAttributeFeatureAdapter(List<Object> features, BiFunction<EObject, Object, Void> subscriber) {
        this.subscriber = subscriber;
        this.features.addAll(features);
    }

    @Override
    public void notifyChanged(Notification notification) {
        super.notifyChanged(notification);
        if (notification.getEventType() != Notification.REMOVING_ADAPTER) {
            if (features.contains(notification.getFeature()) && notification.getFeature() instanceof EAttribute attribute
                    && notification.getNotifier() instanceof EObject eObject) {
                LOGGER.info(attribute.getName() + " CHANGED to " + notification.getNewValue());
                this.subscriber.apply(eObject, notification.getNewValue());
            }
        }
    }
}

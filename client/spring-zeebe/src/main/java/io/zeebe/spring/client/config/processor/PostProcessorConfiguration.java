package io.zeebe.spring.client.config.processor;

import io.zeebe.spring.client.bean.value.factory.ReadAnnotationValueConfiguration;
import io.zeebe.spring.client.bean.value.factory.ReadZeebeDeploymentValue;
import io.zeebe.spring.client.bean.value.factory.ReadZeebeTaskListenerValue;
import io.zeebe.spring.client.bean.value.factory.ReadZeebeTopicListenerValue;
import io.zeebe.spring.client.config.SpringZeebeClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import java.util.List;

@Import(ReadAnnotationValueConfiguration.class)
public class PostProcessorConfiguration
{

    @Bean
    public SubscriptionBuilderPostProcessor subscriptionBuilderPostProcessor(final List<BeanInfoPostProcessor> processors, final SpringZeebeClient client)
    {
        return new SubscriptionBuilderPostProcessor(processors, client);
    }

    @Bean
    public DeploymentPostProcessor deploymentPostProcessor(final ReadZeebeDeploymentValue reader)
    {
        return new DeploymentPostProcessor(reader);
    }

    @Bean
    public TaskHandlerPostProcessor taskhandlerPostProcessor(final ReadZeebeTaskListenerValue reader)
    {
        return new TaskHandlerPostProcessor(reader);
    }

    @Bean
    public TopicHandlerPostProcessor topicHandlerPostProcessor(final ReadZeebeTopicListenerValue reader)
    {
        return new TopicHandlerPostProcessor(reader);
    }

}

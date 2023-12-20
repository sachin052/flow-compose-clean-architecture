package com.example.feature.posts

import app.cash.turbine.test
import assertk.assertThat
import assertk.assertions.isEqualTo
import com.example.core.failure.Failure
import com.example.core.helpers.Either
import com.example.feature.posts.domain.entity.PostEntity
import com.example.feature.posts.domain.use_cases.GetAllPostsUseCasesTest
import com.example.flowexample.features.posts.presentation.PostViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

@ExperimentalCoroutinesApi
class PostViewModelTest {

    private val testDispatcher = StandardTestDispatcher()
    private val testScope = TestScope(testDispatcher)

    @Mock
    lateinit var getAllPostsUseCases: GetAllPostsUseCasesTest

    @InjectMocks
    lateinit var postViewModel: PostViewModel

    @BeforeEach
    fun setup() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun `test loading posts success`() = testScope.runTest {
        // Arrange
        val mockPosts = listOf(PostEntity("1","","",))
        `when`(getAllPostsUseCases.invoke()).thenReturn(flowOf(Either.Right(mockPosts)))

        // Act and Assert using Turbine
        postViewModel.allItems.test {
            // Trigger the flow
            postViewModel.allItems
            assertThat(awaitItem().size ).isEqualTo(1)
            awaitComplete()

        }
    }

    @Test
    fun `test loading posts failure`() = testScope.runTest {
        // Arrange
        val failure = Failure.NetworkFailure
        `when`(getAllPostsUseCases.invoke()).thenReturn(flowOf(Either.Left(failure)))

        // Act and Assert using Turbine
        postViewModel.allItems.test {
            // Trigger the flow
            postViewModel.allItems
            assertThat(awaitItem().size).isEqualTo(0)
            awaitComplete()
        }
    }

}

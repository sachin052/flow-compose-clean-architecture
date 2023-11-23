package com.example.flowexample.features.posts

import app.cash.turbine.test
import com.example.core.failure.Failure
import com.example.core.helpers.Either
import com.example.flowexample.features.posts.domain.entity.PostEntity
import com.example.flowexample.features.posts.domain.use_cases.GetAllPostsUseCasesTest
import com.example.flowexample.features.posts.presentation.PostViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
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

    @Before
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
            assertEquals(awaitItem().size,1 )
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
            assertEquals(awaitItem().size,0 )
            awaitComplete()
        }
    }

}
